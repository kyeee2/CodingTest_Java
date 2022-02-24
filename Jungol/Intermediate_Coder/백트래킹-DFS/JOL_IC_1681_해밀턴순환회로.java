import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_IC_1681_해밀턴순환회로 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, min = Integer.MAX_VALUE;
	static int [][] map;
	static int [] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		result = new int[N];
		
		// 2, 3, 4, ... N-1 의 순열 구하기
		permutation(0, 0, 0, 0);
		
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}

	private static void permutation(int cnt, int pre, int sum, int bits) {
		if(sum > min) return;
		
		if(cnt == N - 1) {
			if(map[pre][0] == 0) return;
			
			sum += map[pre][0];
			if(sum < min) {
				min = sum;
			}
			return;
		}
		
		for(int i = 1; i < N; i++) {
			if(map[pre][i] == 0) continue;
			
			if((bits & 1 << i) != 0) continue;
			
			result[cnt + 1] = i;
			permutation(cnt + 1, i, sum + map[pre][i], bits | 1 << i);
		}
	}

}
