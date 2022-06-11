import java.io.*;
import java.util.*;

public class BJ_S1_18428_감시피하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, result;
	static char [][] map;
	static int [] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static List<Point> teachers = new ArrayList<>();
	static List<Point> blanks = new ArrayList<>();
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		map = new char [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = tokens.nextToken().charAt(0);
				
				if(map[r][c] == 'T') teachers.add(new Point(r, c));
				else if(map[r][c] == 'X') blanks.add(new Point(r, c));
			}
		}
		
		comb(0, 0);
		
		if(result > 0) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void comb(int start, int idx) {
		if(idx == 3) {
			if(checkWatch()) result++;
			return;
		}
		
		for(int i = start; i < blanks.size(); i++) {
			int r = blanks.get(i).r;
			int c = blanks.get(i).c;
			
			map[r][c] = 'O';
			comb(i + 1, idx + 1);
			map[r][c] = 'X';
		}
	}

	private static boolean checkWatch() {
		for(int i = 0; i < teachers.size(); i++) {
			int r = teachers.get(i).r;
			int c = teachers.get(i).c;
			
			for(int dir = 0; dir < 4; dir++) {
				int nr = r;
				int nc = c;
				
				while(true) {
					nr += dr[dir];
					nc += dc[dir];

					if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
					if(map[nr][nc] == 'O') break;
					if(map[nr][nc] == 'S') return false;
				}
			}
		}
		
		return true;
	}

}
