import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_G4_1715_카드정렬하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		int sum = 0;
		while(nums.size() > 1) {
			int num = nums.poll() + nums.poll();
			sum += num;
			nums.add(num);
		}

		System.out.println(sum);
	}

}
