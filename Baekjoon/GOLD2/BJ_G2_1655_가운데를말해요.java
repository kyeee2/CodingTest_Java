import java.io.*;
import java.util.*;

public class BJ_G2_1655_가운데를말해요 {
	
	// 참고블로그
	// https://yabmoons.tistory.com/478

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxHeap.size() > minHeap.size()) minHeap.offer(num);
			else maxHeap.offer(num);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek() > minHeap.peek()) {
					int minNum = minHeap.poll();
					int maxNum = maxHeap.poll();
					
					maxHeap.offer(minNum);
					minHeap.offer(maxNum);
				}
			}
			
			output.append(maxHeap.peek() + "\n");
		}
		
		System.out.println(output);
	}

}
