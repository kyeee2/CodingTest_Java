import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_1205_등수구하기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int score = Integer.parseInt(tokens.nextToken());
		int P = Integer.parseInt(tokens.nextToken());
		
		if(N == 0) {
			System.out.println(1);
			return;
		}
		
		int [] scores = new int [N + 1];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(tokens.nextToken());
		}
		scores[N] = score;
		
		if(N == P && scores[N - 1] >= score) System.out.println(-1);
		else {
			int rank = 1;
			for(int i = 0; i < N; i++) {
				if(scores[i] > score) rank++;
			}
			System.out.println(rank);
		}
		
	}

}
