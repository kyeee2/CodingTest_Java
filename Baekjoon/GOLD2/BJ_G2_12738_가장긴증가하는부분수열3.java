import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G2_12738_가장긴증가하는부분수열3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [] nums, lis;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int [N];
		lis = new int [N];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int j = 0;
		lis[j] = nums[j];
		int i = 1;
		
		while(i < N) {
			// lis 의 가장 마지막 값보다 현재 넣고자 하는 값이 더 크면 맨 뒤에 현재 값 추가해주기
			if(lis[j] < nums[i]) {
				lis[++j] = nums[i];
			} else {
				int idx = binarySearch(0, j, nums[i]);
				lis[idx] = nums[i];
			}
			i++;
		}
		
		System.out.println(j + 1);
	}

	private static int binarySearch(int start, int end, int num) {
		// lis에 num 값이 들어갈 자리를 이분탐색 으로 찾자
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(lis[mid] < num) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return end;
	}

}
