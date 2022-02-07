import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_B1_2456_나는학급회장이다 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] candidates = new int[3][5]; // 후보자 번호, 총점, 1, 2, 3의 개수
		
		// 후보자 번호 초기화
		candidates[0][0] = 1;
		candidates[1][0] = 2;
		candidates[2][0] = 3;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 3; j++) {
				int n = Integer.parseInt(tokens.nextToken()); // (j + 1) 번 후보의 선호 점수
				
				candidates[j][1] += n;
				candidates[j][n + 1]++;
			}
		}
		
		// 후보자 정렬
		Arrays.sort(candidates, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 총 점으로 내림차순
				if(o1[1] == o2[1]) {
					// 총점이 같으면 선호도 점수 3 의 개수로 내림차순
					if(o1[4] == o2[4]) {
						// 선호도 점수 3의 개수도 같다면 선호도 점수 2의 개수로 내림차순
						return Integer.compare(o1[3], o2[3]) * -1;
					} else {
						return Integer.compare(o1[4], o2[4]) * -1;
					}
				} else {
					return Integer.compare(o1[1], o2[1]) * -1;
				}
			}
		});

		if(candidates[0][1] == candidates[1][1]) {
			if(candidates[0][4] == candidates[1][4]) {
				if(candidates[0][3] == candidates[1][3]) {
					System.out.println("0 " + candidates[0][1]);
					return;
				}
			}
		}
		
		System.out.println(candidates[0][0] + " " + candidates[0][1]);
	}

}
