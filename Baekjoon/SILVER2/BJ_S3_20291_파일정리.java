import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_S3_20291_파일정리 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static Map<String, Integer> dict = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine(), ".");
			tokens.nextToken();
			String str = tokens.nextToken();
			if(dict.containsKey(str)) {
				dict.replace(str, dict.get(str) + 1);
			} else {
				dict.put(str, 1);
			}
		}
		
		for(String key: dict.keySet()) {
			output.append(key + " " + dict.get(key) + "\n");
		}
		System.out.println(output);
	}

}
