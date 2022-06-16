import java.io.*;
import java.util.*;

public class BJ_S1_2002_추월 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int N;
	static Map<String, Integer> in = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			in.put(car, i);
		}
		
		int [] out = new int [N];
		for(int i = 0; i < N; i++) {
			String car = br.readLine();
			out[i] = in.get(car);
		}
		
		int ans = 0;
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if(out[i] > out[j]) {
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}

}
