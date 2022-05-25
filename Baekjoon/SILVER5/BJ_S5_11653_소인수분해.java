import java.io.*;

public class BJ_S5_11653_소인수분해 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		if(N == 1) return;
		
		for(int i = 2; i <= N; i++) {
			if(N % i == 0) {
				while(N % i == 0) {
					output.append(i + "\n");
					N /= i;
				}
			}
			if(N == 1) break;
		}
		System.out.println(output);
	}

}
