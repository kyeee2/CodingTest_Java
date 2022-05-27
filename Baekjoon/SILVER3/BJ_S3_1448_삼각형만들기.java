import java.io.*;
import java.util.*;

public class BJ_S3_1448_삼각형만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static Integer [] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new Integer [N];
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(nums, Collections.reverseOrder());
		
		for(int i = 0; i < N - 2; i++) {
			if(nums[i] < nums[i + 1] + nums[i + 2]) {
				System.out.println(nums[i] + nums[i + 1] + nums[i + 2]);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
