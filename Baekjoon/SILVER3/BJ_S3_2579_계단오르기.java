import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S3_2579_계단오르기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] S;
	static int [][] D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		S = new int [N + 1];
		D = new int [N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			S[i] = Integer.parseInt(br.readLine());
		}
		
		// 주의!
		// N이 1일 때 D[2][1] 또는 D[2][2]의 값을 설정할 수 없다!!!
		if(N == 1) {
			System.out.println(S[1]);
			return;
		}
		
		// 초깃값 설정
		D[1][1] = S[1];
		D[1][2] = 0;
		D[2][1] = S[2];
		D[2][2] = S[1] + S[2];
		
		for(int i = 3; i <= N; i++) {
			D[i][1] = Math.max(D[i - 2][1], D[i - 2][2]) + S[i];
			D[i][2] = D[i - 1][1] + S[i];
		}
		
		System.out.println(Math.max(D[N][1], D[N][2]));
	}

}
