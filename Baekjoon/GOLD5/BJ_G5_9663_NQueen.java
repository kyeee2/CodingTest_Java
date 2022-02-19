import java.util.Scanner;

public class BJ_G5_9663_NQueen {

	static int N, result;
	
	static int [] queens; // r행에 c열 -> queens[r] = c

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		queens = new int[N];
		
		for(int i = 0; i < N; i++) {
			findQueen(0, 0, i);			
		}
		
		System.out.println(result);
		
		scan.close();
	}

	private static void findQueen(int cnt, int r, int c) {
		if(r == N - 1) {
			result++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			queens[r] = c;
			if(isPossible(cnt + 1, r + 1, i)) {
				findQueen(cnt + 1, r + 1, i);
			}
		}
	}

	private static boolean isPossible(int cnt, int r, int c) {
		for(int i = 0; i < cnt; i++) {
			if(c == queens[i] || r - i == Math.abs(c - queens[i])) {
				return false;
			}
		}
		return true;
	}

}
