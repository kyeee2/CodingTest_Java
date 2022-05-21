import java.io.*;
import java.util.*;

public class BJ_G4_2580_스도쿠 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int [][] sudoku = new int [9][9];
	static int [][] result = new int [9][9];
	static boolean [][] row = new boolean [9][10];
	static boolean [][] col = new boolean [9][10];
	static boolean [][] square = new boolean [9][10];
	static List<Point> zeros = new ArrayList<>();
	static boolean flag = false;
	
	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		for(int r = 0; r < 9; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < 9; c++) {
				sudoku[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(sudoku[r][c] == 0) {
					zeros.add(new Point(r, c));
				} else {
					int num = sudoku[r][c];
					row[r][num] = true;
					col[c][num] = true;
					square[r / 3 * 3 + c / 3][num] = true;
				}
			}
		}
		
		solution(0);
		
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				output.append(result[r][c] + " ");
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	private static void solution(int cnt) {
		if(flag) return; // 이미 답을 찾은 경우
		if(cnt == zeros.size()) {
			flag = true;
			
			copyResult();
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			int r = zeros.get(cnt).r;
			int c = zeros.get(cnt).c;

			// 이미 행 또는 열 또는 사각형에 같은 숫자가 있는 경우
			if(row[r][i] || col[c][i] || square[r/3*3 + c/3][i]) continue;
			
			// 현재 빈칸에 숫자 채워주기
			sudoku[r][c] = i;
			row[r][i] = true;
			col[c][i] = true;
			square[r / 3 * 3 + c / 3][i] = true;
			
			solution(cnt + 1);
			
			// 빈칸에 숫자 지워주기
			sudoku[r][c] = 0;
			row[r][i] = false;
			col[c][i] = false;
			square[r / 3 * 3 + c / 3][i] = false;
		}
	}

	// 결과 따로 저장하기
	private static void copyResult() {
		for(int r = 0; r < 9; r++) {
			for(int c = 0; c < 9; c++) {
				result[r][c] = sudoku[r][c];
			}
		}
		
	}

}
