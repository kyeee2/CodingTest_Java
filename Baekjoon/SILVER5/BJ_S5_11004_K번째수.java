import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_11004_K번째수 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		List<Integer> nums = new ArrayList<>(N);
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(tokens.nextToken()));
		}
		
		Collections.sort(nums);
		
		System.out.println(nums.get(K - 1));
	}
	
}