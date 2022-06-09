import java.io.*;
import java.util.*;

public class BJ_S3_2108_통계학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int N, sum;
	static int [] nums;
	static TreeMap<Integer, Integer> count = new TreeMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		nums = new int [N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			if(count.containsKey(nums[i])) {
				count.put(nums[i], count.get(nums[i]) + 1);
			} else {
				count.put(nums[i], 1);
			}
		}
		
		output.append((int)Math.round((double)sum / N) + "\n");
		Arrays.sort(nums);
		output.append(nums[N / 2] + "\n");
		int max = -1;
		for(int key: count.keySet()) {
			if(max < count.get(key)) {
				max = count.get(key);
			}
		}
		int mode = 0, cnt = 0;
		for(int key: count.keySet()) {
			if(count.get(key) == max) {
				if(cnt == 1) {
					mode = key;
					break;
				}
				mode = key;
				cnt++;
			}
		}
		output.append(mode + "\n");
		output.append(nums[N - 1] - nums[0]);
		
		System.out.println(output);
	}

}
