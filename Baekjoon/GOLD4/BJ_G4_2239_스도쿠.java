import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_G4_2239_스도쿠 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N = 9;
	static boolean flag = true;
	static int [][] sudoku = new int [N][N];
	static boolean [][] row = new boolean [N][10];
	static boolean [][] col = new boolean [N][10];
	static boolean [][] square = new boolean [N][10];
	static List<Point> zeros = new ArrayList<>();
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				sudoku[r][c] = line.charAt(c) - '0';
				if(sudoku[r][c] == 0) zeros.add(new Point(r, c));
				else {
					row[r][sudoku[r][c]] = true;
					col[c][sudoku[r][c]] = true;
					square[(r / 3) * 3 + (c / 3)][sudoku[r][c]] = true;
				}
			}
		}
		
		dfs(0);
		System.out.println(output);
	}

	private static void dfs(int idx) {
		if(!flag) return;
		if(idx == zeros.size()) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					output.append(sudoku[r][c]);
				}
				output.append("\n");
			}
			flag = false;
			
			return;
		}
		
		int r = zeros.get(idx).r;
		int c = zeros.get(idx).c;
		
		for(int n = 1; n < 10; n++) {
			if(!row[r][n] && !col[c][n] && !square[(r / 3) * 3 + (c / 3)][n]) {
				sudoku[r][c] = n;
				row[r][n] = true;
				col[c][n] = true;
				square[(r / 3) * 3 + (c / 3)][n] = true;
				dfs(idx + 1);
				sudoku[r][c] = 0;
				row[r][n] = false;
				col[c][n] = false;
				square[(r / 3) * 3 + (c / 3)][n] = false;
			}
		}
	}
}
