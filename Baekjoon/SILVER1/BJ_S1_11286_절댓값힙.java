import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_S1_11286_절댓갑힙 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N;
	static PriorityQueue<Number> pQ = new PriorityQueue<>();
	
	static class Number implements Comparable<Number> {
		int absNumber, number;
		
		public Number (int absNumber, int number) {
			this.absNumber = absNumber;
			this.number = number;
		}

		@Override
		public int compareTo(Number o) {
			if(this.absNumber == o.absNumber) {
				return Integer.compare(this.number, o.number);
			} else {
				return Integer.compare(this.absNumber, o.absNumber);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) {
				if(pQ.isEmpty()) {
					output.append("0\n");
				} else {
					output.append(pQ.poll().number + "\n");
				}
			} else {
				pQ.offer(new Number(Math.abs(n), n));
			}
		}
		
		System.out.println(output);
	}

}
