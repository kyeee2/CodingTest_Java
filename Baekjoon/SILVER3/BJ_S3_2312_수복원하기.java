import java.io.*;

public class BJ_S3_2312_수복원하기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			
			for(int i = 2; i <= N; i++) {
				if(N % i == 0) {
					int cnt = 0;
					while(N % i == 0) {
						cnt++;
						N /= i;
					}
					
					output.append(i + " " + cnt + "\n");
				}
				if(N == 1) break;
			}
		}
		System.out.println(output);
	}

}
