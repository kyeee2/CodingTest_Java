import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_G3_1941_소문난칠공주 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int result;
	static int [] selected = new int [7];
	static int [][] map = new int [5][5];
	static boolean [][] visited;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; 
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		for(int r = 0; r < 5; r++) {
			String line = br.readLine();
			for(int c = 0; c < 5; c++) {
				if(line.charAt(c) == 'S') {
					map[r][c] = 1; // 이다솜파
				} else {
					map[r][c] = 0; // 임도연파
				}
			}
		}
		
		comb(0, 0);
		
		System.out.println(result);
	}

	private static void comb(int idx, int start) {
		if(idx == 7) {
			// 일단 뽑은 아이들 체크
			int s = 0, y = 0; // 이다솜파, 임도연파
			visited = new boolean [5][5];
			for(int i = 0; i < 7; i++) {
				int r = selected[i] / 5;
				int c = selected[i] % 5;
				
				if(map[r][c] == 1) s++;
				else			   y++;
				visited[r][c] = true;
			}
			
			// 이다솜파가 4명 이상인 경우에만 연결 체크
			if(s >= 4) {
				if(isConnected()) {
					result++;
				}
			}
			return;
		}
		
		for(int i = start; i < 25; i++) {
			selected[idx] = i;
			comb(idx + 1, i + 1);
		}
	}

	private static boolean isConnected() {
		Queue<Point> Q = new LinkedList<>();
		
		Q.add(new Point(selected[0] / 5, selected[0] % 5));
		visited[selected[0] / 5][selected[0] % 5] = false;
		int cnt = 0;
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			cnt++;
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5|| !visited[nr][nc]) continue;
				
				Q.add(new Point(nr, nc));
				visited[nr][nc] = false;
			}
		}
		
		if(cnt == 7) return true;
		else		 return false;
	}
}
