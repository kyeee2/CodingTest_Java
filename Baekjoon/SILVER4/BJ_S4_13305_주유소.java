import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		long [] roads = new long [N - 1];
		long [] costs = new long [N];
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N - 1; i++) {
			roads[i] = Long.parseLong(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			costs[i] = Long.parseLong(tokens.nextToken());
		}
		
		long cost = costs[0];
		long sum = cost * roads[0];
		for(int i = 1; i < N - 1; i++) {
			if(costs[i] < cost) {
				cost = costs[i];
			}
			sum += cost * roads[i];
		}
		
		System.out.println(sum);

	}

}
