import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G2_1202_보석도둑 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, K, C;
	static Jewel [] jewels;
	static int [] bags;
	
	static class Jewel {
		int m, v; // m: 무게, v: 가격
		
		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		jewels = new Jewel [N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			
			jewels[i] = new Jewel(m, v);
		}
		
		bags = new int [K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels, (j1, j2) -> Integer.compare(j1.m, j2.m)); // 무게 순으로 오름차순
		Arrays.sort(bags); // 무게 순으로 오름차순
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>((n1, n2) -> Integer.compare(n1, n2) * -1); // 최대힙
		int ind = 0;
		long sum = 0;
		for(int i = 0; i < K; i++) {
			
			// 가방의 무게를 넘지 않는 보석을 우선순위 큐에 넣기
			while(ind < N && jewels[ind].m <= bags[i]) {
				pQ.offer(jewels[ind++].v);
			}
			
			if(!pQ.isEmpty()) {
				sum += pQ.poll();
			}
		}
		
		System.out.println(sum);
	}

}
