import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B1_2563_색종이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static boolean [][] map = new boolean [101][101];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			for(int r = n1; r < n1 + 10; r++) {
				for(int c = n2; c < n2 + 10; c++) {
					map[r][c] = true;
				}
			}
		}
		
		int sum = 0;
		for(int r = 1; r <= 100; r++) {
			for(int c = 1; c <= 100; c++) {
				if(map[r][c]) sum++;
			}
		}
		
		System.out.println(sum);

	}

}
