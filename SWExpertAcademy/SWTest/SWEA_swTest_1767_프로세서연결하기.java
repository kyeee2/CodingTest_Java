import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_swTest_1767_프로세서연결하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, maxCnt, minSum;
	static int [][] map;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static List<Point> cores = new ArrayList<>(); // core들의 위치
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			cores.clear();
			
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] == 1 && r > 0 && r < N - 1 && c > 0 && c < N - 1) { // 벽에 붙어있는 경우는 무시
						cores.add(new Point(r, c));
					}
				}
			}
			
			maxCnt = 0;
			minSum = 0;
			dfs(0, 0, 0, new boolean [N][N]);
			
			output.append(String.format("#%d %d\n", t, minSum));
		}
		System.out.println(output);
	}

	private static void dfs(int idx, int cnt, int sum, boolean [][] visited) {
		if(idx == cores.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minSum = sum;
			} else if(cnt == maxCnt && sum < minSum) {
				minSum = sum;
			}
			return;
		}
		
		boolean flag = true;
		for(int i = 0; i < 4; i++) {
			// 현재 연결 상태를 복사
			boolean [][] temp = copy(visited);
			// 복사된 연결 상태에 현재 코어를 해당 방향으로 연결 시도
			int s = fill(cores.get(idx).r, cores.get(idx).c, i, temp);
			if(s == -1) {
				// 연결 실패
			} else {
				// 연결에 성공하면 갱신 된 연결 상태를 전달
				dfs(idx + 1, cnt + 1, sum + s, temp);
				flag = false;
			}
		}
		
		// 현재 코어가 한 번도 연결에 성공하지 못한 경우
		if(flag) {
			// 전달 받은 연결 상태를 전달
			dfs(idx + 1, cnt, sum, visited);
		}
	}

	// 연결 상태 복사하기
	private static boolean[][] copy(boolean[][] visited) {
		boolean [][] temp = new boolean [N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				temp[r][c] = visited[r][c];
			}
		}
		
		return temp;
	}

	// 연결 상태 갱신하기
	private static int fill(int r, int c, int i, boolean[][] temp) {
		int nr = r + dr[i];
		int nc = c + dc[i];
		int cnt = 0;
		while(true) {
			// 벽에 닿는 경우 연결 성공
			if(nr == -1 || nc == -1 || nr == N || nc == N) break;
			
			// 다른 코어나 다른 연결 선에 닿은 경우 연결 실패
			if(map[nr][nc] == 1 || temp[nr][nc]) {
				return -1;
			}
			temp[nr][nc] = true;
			cnt++;
			
			nr += dr[i];
			nc += dc[i];
		}
		
		return cnt;
	}

}
