import java.io.*;

public class BJ_B2_5988_홀수일까짝수일까 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String num = br.readLine();
			if((num.charAt(num.length() - 1) - '0') % 2 == 0) output.append("even\n");
			else output.append("odd\n");
		}
		System.out.println(output);
	}

}
