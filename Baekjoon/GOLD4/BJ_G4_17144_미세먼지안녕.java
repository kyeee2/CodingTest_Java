import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_17144_미세먼지안녕 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C, T, top, bottom;
	static int [][] map, temp;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		map = new int [R][C];
		for(int r = 0; r < R; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == -1) {
					bottom = r;
				}
			}
		}
		top = bottom - 1;
		
		for(int t = 0; t < T; t++) {
			temp = new int [R][C];
			spread();
			rotation();
		}
		
		System.out.println(sum());
	}

	private static void spread() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] <= 0) continue;
				
				if(map[r][c] >= 5) {
					int n = map[r][c] / 5;
					for(int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) continue;
						temp[nr][nc] += n;
						map[r][c] -= n;
					}
				}
				
				temp[r][c] += map[r][c];
			}
		}
	}

	private static void rotation() {
		// 위쪽 공기청정기
		// 테두리가 아닌 곳은 그대로
		for(int r = 1; r < top; r++) {
			for(int c = 1; c < C - 1; c++) {
				map[r][c] = temp[r][c];
			}
		}
		// 공기 순환
		// ↓
		for(int r = 0; r < top-1; r++) {
			map[r + 1][0] = temp[r][0];
		}
		// ←
		for(int c = 1; c < C; c++) {
			map[0][c - 1] = temp[0][c];
		}
		// ↑
		for(int r = 1; r <= top; r++) {
			map[r - 1][C - 1] = temp[r][C - 1];
		}
		// →
		for(int c = 1; c < C - 1; c++) {
			map[top][c + 1] = temp[top][c];
		}
		map[top][1] = 0;
		
		// 아래쪽 공기청정기
		// 테두리가 아닌 곳은 그래도
		for(int r = bottom + 1; r < R; r++) {
			for(int c = 1; c < C - 1; c++) {
				map[r][c] = temp[r][c];
			}
		}
		// 공기 순환
		// ↑
		for(int r = bottom + 2; r < R; r++) {
			map[r - 1][0] = temp[r][0];
		}
		// ←
		for(int c = 1; c < C; c++) {
			map[R - 1][c - 1] = temp[R - 1][c];
		}
		// ↓
		for(int r = bottom; r < R - 1; r++) {
			map[r + 1][C - 1] = temp[r][C - 1];
		}
		// →
		for(int c = 1; c < C - 1; c++) {
			map[bottom][c + 1] = temp[bottom][c];
		}
		map[bottom][1] = 0;
	}

	private static int sum() {
		int total = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == -1) continue;
				total += map[r][c];
			}
		}
		return total;
	}

}
