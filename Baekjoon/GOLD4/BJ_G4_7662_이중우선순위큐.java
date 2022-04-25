import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_G4_7662_이중우선순위큐 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N;
	static TreeMap<Integer, Integer> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			for(int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				char ch = tokens.nextToken().charAt(0);
				int n = Integer.parseInt(tokens.nextToken());
				
				if(ch == 'I') {
					if(map.containsKey(n)) map.replace(n, map.get(n) + 1);
					else map.put(n, 1);
				} else {
					if(map.isEmpty()) {
						continue;
					} 
					
					int key = 0;
					if(n == 1) {
						key = map.lastKey();
					} else {
						key = map.firstKey();
					}
					if(map.get(key) == 1) map.remove(key);
					else map.replace(key, map.get(key) - 1);
				}
			}
			if(map.isEmpty()) output.append("EMPTY\n");
			else output.append(map.lastKey() + " " + map.firstKey() + "\n");
		}
		System.out.println(output);
	}

}
