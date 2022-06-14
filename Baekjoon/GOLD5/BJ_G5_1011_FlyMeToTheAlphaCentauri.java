import java.io.*;
import java.util.*;

public class BJ_G5_1011_FlyMeToTheAlphaCentauri {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			long x = Long.parseLong(tokens.nextToken());
			long y = Long.parseLong(tokens.nextToken());
			
			long k = 0;
			while(true) {
				if(y - x <= k * (k + 1)) break;
				k++;
			}
			
			if(y - x <= k * k) output.append((2 * k - 1) + "\n");
			else output.append((2 * k) + "\n");
		}
		System.out.println(output);
	}
}
