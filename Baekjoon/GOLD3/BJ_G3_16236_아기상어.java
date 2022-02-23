package bj.g3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_16236_아기상어 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, time;
	static int [][] map;
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	static Fish shark;
	static Queue<Fish> Q = new LinkedList<>();
	
	static class Fish {
		int r, c, size, eatCount, dist;
		
		public Fish(int r, int c, int size, int eatCount, int d) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.eatCount = eatCount;
			this.dist = d;
		}
		
		@Override
		public String toString() {
			return this.r + ", " + this.c + " : " + this.size + ", " + this.eatCount + ", " + this.dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		int feedCnt = 0; // 먹이의 개수
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int num = Integer.parseInt(tokens.nextToken());
				
				map[r][c] = num;
				if(num == 9) {
					shark = new Fish(r, c, 2, 0, 0);
					map[r][c] = 0; // 상어 위치는 0으로 바꾸기
				} else if(num == 1) {
					feedCnt++;
				}
			}
		}
		
		// 먹이가 하나도 없는 경우
		if(feedCnt == 0) {
			System.out.println(0);
			return;
		}

		PriorityQueue<Fish> feeds = new PriorityQueue<>((f1, f2) ->  {
			if(f1.dist == f2.dist) {
				if(f1.r == f2.r) {
					return Integer.compare(f1.c, f2.c);
				} else {
					return Integer.compare(f1.r, f2.r);
				}
			} else {
				return Integer.compare(f1.dist, f2.dist);
			}
		}); // 먹이 위치 저장
		
		Q.offer(shark);
		
		while(true) {
			// 현재 위치 방문 여부
			visited = new boolean [N][N];
			// 처음 상어 위치 방문 체크
			visited[Q.peek().r][Q.peek().c] = true;
			
			// 먹이 찾기
			while(!Q.isEmpty()) {
				Fish fish = Q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nr = fish.r + dr[i];
					int nc = fish.c + dc[i];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 인덱스 벗어남
					if(visited[nr][nc] || fish.size < map[nr][nc]) continue; // 이미 방문했거나 물고기 크기가 더 큰 경우
					
					// 상어의 몸집보다 작으면서 먹이가 없는 곳이 아닌 경우
					if(fish.size > map[nr][nc] && map[nr][nc] != 0) {
						feeds.offer(new Fish(nr, nc, fish.size, fish.eatCount + 1, fish.dist + 1));
					}
					
					Q.offer(new Fish(nr, nc, fish.size, fish.eatCount, fish.dist + 1));
					visited[nr][nc] = true;
				}
			}
			
			// 먹이가 없으면 엄마 찾기
			if(feeds.isEmpty()) {
				System.out.println(time);
				return;
			}
			
			// 먹이 찾기
			Fish fish = feeds.poll(); // 가장 우선순위가 높은 먹이 꺼내기
			// 상어의 크기와 상어가 먹은 물고기의 수가 같으면
			if(fish.size == fish.eatCount) {
				fish.size++; // 상어 크기 키워주기
				fish.eatCount = 0; // 상어가 먹은 물고기 수 초기화
			}
			// 먹은 곳 0으로
			map[fish.r][fish.c] = 0;
			// 움직인 거리 늘려주기
			time += fish.dist;
			// 상어 넣어주기
			Q.offer(new Fish(fish.r, fish.c, fish.size, fish.eatCount, 0));
			// 먹이 찾은거 초기화
			feeds.clear();
		}
	}

}
