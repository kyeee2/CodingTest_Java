import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_8458_원점으로집합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T, N, max;
	static int [] points;

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		TC: for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			points = new int [N];
			max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				tokens = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(tokens.nextToken());
				int n2 = Integer.parseInt(tokens.nextToken());
				
				// (x, y)의 좌표값을 (|x| + |y|, 0), (0, |x| + |y|) 로 바꿔서 생각해주기
				points[i] = Math.abs(n1) + Math.abs(n2); // 절댓값 합 저장
				max = Math.max(max, points[i]); // 그 중 가장 큰 값 저장
			}
			
			boolean even = points[0] % 2 == 0; // 처음 값이 짝수인지 홀수인지 판단
			for(int i = 1; i < N; i++) {
				// 전부다 짝수이거나 전부다 홀수인 경우에만 답을 구할 수 있다.
				// 만약 짝수와 홀수가 섞여있다면 모든 점을 원점으로 이동시킬 수 없는 경우가 된다.
				if(even != (points[i] % 2 == 0)) {
					output.append(String.format("#%d -1\n", t));
					continue TC;
				}
			}
			
			int i = 1; // 인덱스
			int sum = 0; // 누적합
			int ans = 0; // 이동 횟수
			while(true) {
				// 누적합이 가장 큰 수보다 크고, 두 수의 차이가 짝수인 경우엔 원점에 도달할 수 있다.
				if(sum >= max && Math.abs(sum - max) % 2 == 0) break;
				
				sum += i;
				i++;
				ans++;
			}
			
			output.append(String.format("#%d %d\n", t, ans));
		}
		System.out.println(output);
	}

}
