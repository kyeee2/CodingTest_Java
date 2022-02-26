import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_S2_1927_최소힙 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pQ.isEmpty()) {
					output.append("0\n");
				} else {
					output.append(pQ.poll() + "\n");
				}
			} else {
				pQ.offer(n);
			}
		}
		
		System.out.println(output);

	}

}
