import java.io.*;

public class BJ_S5_2018_수들의합5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int [] sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		sum = new int [N + 1];
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + i;
		}
		
		int cnt = 0;
		int st = 0, end = 1;
		while(st < end) {
			if(sum[end] - sum[st] == N) {
				cnt++;
				st++;
			} else if(sum[end] - sum[st] > N) {
				st++;
			} else if(sum[end] - sum[st] < N) {
				end++;
			}
		}
		
		System.out.println(cnt);
	}

}
