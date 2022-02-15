import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static long N, R, C;
	static long result, cnt;
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		find(0, 0, 1 << N);
		
		System.out.println(result);
		
	}

	private static void find(int r, int c, int n) {
		if(r == R && c == C) {		
			result = cnt;
			return;
		}
		
		if(R >= r && R < r + n && C >= c && C < c + n) {
			find(r, c, n / 2);
			find(r, c + n / 2, n / 2);
			find(r + n / 2, c, n / 2);
			find(r + n / 2, c + n / 2, n / 2);
		} else {
			cnt += n * n;
		}
	}

}
