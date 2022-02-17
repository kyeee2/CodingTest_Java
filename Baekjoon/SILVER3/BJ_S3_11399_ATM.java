import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S3_11399_ATM {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> nums = new ArrayList<Integer>(N);
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(tokens.nextToken()));
		}
		
		Collections.sort(nums); // 오름차순 정렬
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += nums.get(i) * (N - i);
		}
		
		System.out.println(sum);

	}

}
