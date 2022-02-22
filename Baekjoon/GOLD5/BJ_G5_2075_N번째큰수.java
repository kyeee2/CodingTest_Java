import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_2075_N번째큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>(); // 최소힙
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pQ.offer(Integer.parseInt(tokens.nextToken()));
				if(pQ.size() > N) {
					pQ.poll();
				}
			}
		}
		
		System.out.println(pQ.poll());
	}

}
