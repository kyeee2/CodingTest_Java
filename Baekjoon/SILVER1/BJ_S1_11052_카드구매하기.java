import java.io.*;
import java.util.*;

public class BJ_S1_11052_카드구매하기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] cards, D;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		cards = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(tokens.nextToken());
		}
		
		D = new int [N + 1];
		D[1] = cards[1];
		
		for(int i = 2; i <= N; i++) {
			D[i] = cards[i];
			
			for(int j = 1; j < i; j++) {
				D[i] = Math.max(D[i], D[j] + D[i - j]);
			}
		}
		
		System.out.println(D[N]);
	}

}
