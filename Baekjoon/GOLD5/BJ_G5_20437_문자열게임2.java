import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ_G5_20437_문자열게임2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int T, N;
	static String word;
	static Map<Character, List<Integer>> alp; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			word = br.readLine();
			N = Integer.parseInt(br.readLine());
			
			alp = new HashMap<>();
			for(char alpha = 'a'; alpha <= 'z'; alpha++) {
				alp.put(alpha, new ArrayList<>());
			}
			
			for(int idx = 0; idx < word.length(); idx++) {
				alp.get(word.charAt(idx)).add(idx);
			}
			
			boolean flag = true;
			int max = -1, min = Integer.MAX_VALUE;
			for(char key: alp.keySet()) {
				if(alp.get(key).size() >= N) {
					List<Integer> idx = alp.get(key);
					for(int i = 0; i <= idx.size() - N; i++) {
						min = Math.min(min, idx.get(i + N - 1) - idx.get(i) + 1);
						max = Math.max(max, idx.get(i + N - 1) - idx.get(i) + 1);
					}
					flag = false;
				}
			}
			
			if(flag) output.append("-1\n");
			else	 output.append(min + " " + max + "\n");
		}
		System.out.println(output);
	}

}
