import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_G5_2170_선긋기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int [N][2];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(arr, (n1, n2) -> {
			if(n1[0] == n2[0]) {
				return Integer.compare(n1[1], n2[1]) * -1;
			} else {
				return Integer.compare(n1[0], n2[0]);
			}
		});
		
		int sum = 0;
		int start = arr[0][0];
		int end = arr[0][1];
		for(int i = 1; i < N; i++) {
			if(end < arr[i][0]) {
				sum += end - start;
				start = arr[i][0];
				end = arr[i][1];
			} else {
				if(end < arr[i][1])	end = arr[i][1];
			}
		}
		sum += end - start;
		System.out.println(sum);
	}

}
