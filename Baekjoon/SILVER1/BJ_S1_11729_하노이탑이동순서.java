import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_11729_하노이탑이동순서 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, K, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 3);
		
		System.out.println(cnt);
		System.out.println(output);
	}

	private static void hanoi(int n, int i, int j) {
		if(n == 1) {
			output.append(i + " " + j + "\n"); // 원판이 하나만 남았다면 이동
			cnt++;
			return;
		}
	
		hanoi(n - 1, i, 6 - i - j); // n-1 번째 원판을 i에서 6-i-j로 이동
		output.append(i + " " + j + "\n"); // n번째 원판을 i에서 j로 이동
		cnt++;
		hanoi(n - 1, 6 - i - j, j); // n-1번째 원판을 이동시킨 곳에서 j로 이동
	}

}
