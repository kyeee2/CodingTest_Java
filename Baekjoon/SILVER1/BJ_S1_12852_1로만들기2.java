import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_S1_12852_1로만들기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, cnt;
	static int [] D, pre;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		D = new int [N + 1];
		pre = new int [N + 1];
		
		D[1] = 0;
		for(int i = 2; i <= N; i++) {
			D[i] = D[i - 1] + 1;
			pre[i] = i - 1;
			if(i % 2 == 0 && D[i / 2] + 1 < D[i]) {
				D[i] = D[i / 2] + 1;
				pre[i] = i / 2;
			}
			if(i % 3 == 0 && D[i / 3] + 1 < D[i]) {
				D[i] = D[i / 3] + 1;
				pre[i] = i / 3;
			}
		}

		output.append(D[N] + "\n" + N + " ");
		while(N > 1) {
			output.append(pre[N] + " ");
			N = pre[N];
		}
		System.out.println(output);
	}

}
