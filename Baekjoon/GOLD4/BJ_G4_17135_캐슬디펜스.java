import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, D, max = -1, total = 0;
	static int [][] map;
	static int [] archers = new int [3];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		
		map = new int [N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) total++; // 총 적의 수
			}
		}
		
		comb(0, 0);
		
		System.out.println(max);
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			int [][] temp = copy();
			max = Math.max(max, fight(temp));
			return;
		}
		
		for(int i = start; i < M; i++) {
			archers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static int[][] copy() {
		int [][] temp = new int [N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][c] = map[r][c];
			}
		}
		
		return temp;
	}

	private static int fight(int[][] copyMap) {
		int copyTotal = total, cnt = 0;
		
		for(int n = 0; n < N; n++) {
			if(copyTotal == 0) break;
			
			int [][] enemy = new int [3][2]; // 처리할 적의 위치
			for(int [] row: enemy) Arrays.fill(row, -1);
			
			// 처리할 적 탐색
			for(int i = 0; i < 3; i++) {
				// 현재 궁수의 위치에서 반원으로 탐색하기
				find: for(int d = 1; d <= D; d++) {
					int r = N - 1;
					int c = archers[i] - d + 1;
					
					boolean flag = true;
					while(r < N) {
						if(r >= 0 && c >= 0 && c < M && copyMap[r][c] == 1) {
							enemy[i][0] = r;
							enemy[i][1] = c;
							break find;
						}
						
						if(c == archers[i]) flag = false;
						if(flag) {
							r--;
						} else {
							r++;
						}
						c++;
					}
				}
			}
			
			// 적 제거하기
			for(int i = 0; i < 3; i++) {
				if(enemy[i][0] == -1) continue; // 처리할 수 있는 적이 없음
				
				// 아직 처리되지 않은 적이 있는 경우
				if(copyMap[enemy[i][0]][enemy[i][1]] == 1) {
					copyMap[enemy[i][0]][enemy[i][1]] = 0;
					cnt++;
					copyTotal--;
				}
			}
			
			// 적 전진
			for(int i = 0; i < M; i++) {
				if(copyMap[N - 1][i] == 1) copyTotal--;
			}
			for(int i = N - 1; i > 0; i--) {
				copyMap[i] = copyMap[i - 1];
			}
			int [] row = new int [M];
			copyMap[0] = row;
		}
		
		return cnt;
	}

}
