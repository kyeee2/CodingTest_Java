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
			sudoku[r][c] = n;
			if(isPossible(r, c)) {
				dfs(idx + 1);
			}
			sudoku[r][c] = 0;
		}
	}

	private static boolean isPossible(int r, int c) {
		// 사각형
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(r - r % 3 + i == r && c - c % 3 + j == c) continue;
				if(sudoku[r - r % 3 + i][c - c % 3 + j] == sudoku[r][c]) return false;
			}
		}
		
		// 가로
		for(int i = 0; i < N; i++) {
			if(c == i) continue;
			if(sudoku[r][i] == sudoku[r][c]) return false;
		}
		
		// 세로
		for(int i = 0; i < N; i++) {
			if(r == i) continue;
			if(sudoku[i][c] == sudoku[r][c]) return false;
		}
		
		return true;
	}

}
