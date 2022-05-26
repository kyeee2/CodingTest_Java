import java.io.*;
import java.util.*;

public class BJ_S3_1935_후위표기식2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String line;
	static int N;
	static double [] alp;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		line = br.readLine();
		alp = new double [N];
		for(int i = 0; i < N; i++) {
			alp[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> S = new Stack<>();
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '+') {
				double n1 = S.pop();
				double n2 = S.pop();
				S.push(n1 + n2);
			} else if(line.charAt(i) == '-') {
				double n1 = S.pop();
				double n2 = S.pop();
				S.push(n2 - n1);
			} else if(line.charAt(i) == '*') {
				double n1 = S.pop();
				double n2 = S.pop();
				S.push(n1 * n2);
			} else if(line.charAt(i) == '/') {
				double n1 = S.pop();
				double n2 = S.pop();
				S.push(n2 / n1);
			} else {
				S.push(alp[line.charAt(i) - 'A']);
			}
		}
		
		System.out.println(String.format("%.2f", S.pop()));
	}

}
