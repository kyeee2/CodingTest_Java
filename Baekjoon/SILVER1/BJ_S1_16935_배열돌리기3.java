package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_16935_배열돌리기3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, R, type;
	static int [][] arr, temp;

	public static void main(String[] args) throws IOException {

		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		arr = new int[N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			type = Integer.parseInt(tokens.nextToken());
			switch(type) {
			case 1:
				turn1();
				break;
			case 2:
				turn2();
				break;
			case 3:
				turn3();
				break;
			case 4:
				turn4();
				break;
			case 5:
				turn5();
				break;
			case 6:
				turn6();
				break;
			}
			
			arr = temp;
		}
		
		for(int [] row : arr) {
			for(int num : row) {
				output.append(num).append(" ");
			}
			output.append('\n');
		}
		
		System.out.println(output);

	}

	// 상하 반전
	private static void turn1() {		
		temp = new int [N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[N - r - 1][c] = arr[r][c];
			}
		}
	}
	
	// 좌우 반전
	private static void turn2() {
		temp = new int [N][M];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[r][M - c - 1] = arr[r][c];
			}
		}
	}
	
	// 오른쪽으로 90도 회전
	private static void turn3() {
		temp = new int [M][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[c][N - r - 1] = arr[r][c];
			}
		}
		
		int n = N;
		N = M;
		M = n;
	}
	
	// 왼쪽으로 90도 회전
	private static void turn4() {
		temp = new int [M][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				temp[M - c - 1][r] = arr[r][c];
			}
		}

		int n = N;
		N = M;
		M = n;
	}
	
	// 그룹 오른쪽으로 회전
	private static void turn5() {
		temp = new int [N][M];
		// 1번그룹 -> 2번그룹
		for(int r = 0; r < N / 2; r++) {
			for(int c = 0; c < M / 2; c++) {
				temp[r][c + M / 2] = arr[r][c];
			}
		}
		// 2번그룹 -> 3번그룹
		for(int r = 0; r < N / 2; r++) {
			for(int c = M / 2; c < M; c++) {
				temp[r + N / 2][c] = arr[r][c];
			}
		}
		// 3번그룹 -> 4번그룹
		for(int r = N / 2; r < N; r++) {
			for(int c = M / 2; c <M; c++) {
				temp[r][c - M / 2] = arr[r][c];
			}
		}
		// 4번그룹 -> 1번그룹
		for(int r = N / 2; r < N; r++) {
			for(int c = 0; c < M / 2; c++) {
				temp[r - N / 2][c] = arr[r][c];
			}
		}
	}

	// 그룹 왼쪽으로 회전
	private static void turn6() {
		temp = new int [N][M];
		// 1번그룹 -> 4번그룹
		for(int r = 0; r < N / 2; r++) {
			for(int c = 0; c < M / 2; c++) {
				temp[r + N / 2][c] = arr[r][c];
			}
		}
		// 4번그룹 -> 3번그룹
		for(int r = N / 2; r < N; r++) {
			for(int c = 0; c < M / 2; c++) {
				temp[r][c + M / 2] = arr[r][c];
			}
		}
		// 3번그룹 -> 2번그룹
		for(int r = N / 2; r < N; r++) {
			for(int c = M / 2; c <M; c++) {
				temp[r - N / 2][c] = arr[r][c];
			}
		}
		// 2번그룹 -> 1번그룹
		for(int r = 0; r < N / 2; r++) {
			for(int c = M / 2; c < M; c++) {
				temp[r][c - M / 2] = arr[r][c];
			}
		}
	}
}
