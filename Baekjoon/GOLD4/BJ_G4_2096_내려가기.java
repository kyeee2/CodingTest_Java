import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_2096_내려가기 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N;
	static int [] minD, maxD;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		minD = new int [3];
		maxD = new int [3];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(tokens.nextToken());
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = Integer.parseInt(tokens.nextToken());
			
			if(r == 0) {
				minD[0] = maxD[0] = n0;
				minD[1] = maxD[1] = n1;
				minD[2] = maxD[2] = n2;
			} else {
				int beforeMin0 = minD[0], beforeMin2 = minD[2];
				minD[0] = Math.min(minD[0], minD[1]) + n0;
				minD[2] = Math.min(minD[1], minD[2]) + n2;
				minD[1] = Math.min(Math.min(beforeMin0, minD[1]), beforeMin2) + n1;
				
				// 최댓값
				int beforeMax0 = maxD[0], beforeMax2 = maxD[2];
				maxD[0] = Math.max(maxD[0], maxD[1]) + n0;
				maxD[2] = Math.max(maxD[1], maxD[2]) + n2;
				maxD[1] = Math.max(Math.max(beforeMax0, maxD[1]), beforeMax2) + n1;
				
			}
		}
	
		int maxSum = Math.max(maxD[0], Math.max(maxD[1], maxD[2]));
		int minSum = Math.min(minD[0], Math.min(minD[1], minD[2]));
		System.out.println(maxSum + " " + minSum);
	}

}
