import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_P5_16496_큰수만들기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static String answer;
	static String [] nums;	

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = br.readLine().split(" ");
		
		Arrays.sort(nums, (str1, str2) -> (str1 + str2).compareTo(str2 + str1) * -1);
		
		if(nums[0].equals("0")) {
			System.out.println("0");
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			output.append(nums[i]);
		}
		
		System.out.println(output);
	}

}
