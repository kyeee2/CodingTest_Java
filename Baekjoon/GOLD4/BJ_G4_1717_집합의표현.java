import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_1717_집합의표현 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M;
	static int [] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		p = new int [N + 1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(tokens.nextToken());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			if(command == 0) { // 합집합
				union(a, b);
			} else { // 같은 집합인지 확인
				if(find(a) == find(b)) output.append("YES\n");
				else				   output.append("NO\n");
			}
		}
		System.out.println(output);
	}
	
	private static int find(int x) {
		if(p[x] == x) return x;
		else return p[x] =  find(p[x]);
	}
	
	private static void union(int x, int y) {
		if(find(x) == find(y)) return;
		else p[find(x)] = find(y);
	}

}
