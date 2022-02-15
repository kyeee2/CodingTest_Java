import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_IC_1828_냉장고 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		int [][] temps = new int [N][2];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			temps[i][0] = Integer.parseInt(tokens.nextToken());
			temps[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(temps, (t1, t2)->Integer.compare(t1[1], t2[1]));
		
		int cnt = 1;
		int high = temps[0][1];
		for(int i = 1; i < N; i++) {
			if(temps[i][0] > high) {
				high = temps[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
}
