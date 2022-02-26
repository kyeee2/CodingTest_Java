import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_16987_계란으로계란치기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, max = -1;
	static Egg [] eggs;
	static boolean [] visited;
	
	static class Egg {
		int s, w;
		
		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			eggs[i] = new Egg(s, w);
		}
		
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int ind) {
		if(ind == N) {
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(eggs[i].s <= 0) cnt++;
			}
			if(max < cnt) max = cnt;
			
			return;
		}
		if(eggs[ind].s <= 0) dfs(ind + 1);
		else {
			boolean flag = false; // 한번이라도 현재 계란으로 다른 계란을 쳤는가?
			for(int i = 0; i < N; i++) {
				if(ind == i || eggs[i].s <= 0) continue;
				
				flag = true;
				eggs[i].s -= eggs[ind].w;
				eggs[ind].s -= eggs[i].w;
				dfs(ind + 1);
				eggs[i].s += eggs[ind].w;
				eggs[ind].s += eggs[i].w;
			}
			if(!flag) dfs(N); 
		}
	}

}
