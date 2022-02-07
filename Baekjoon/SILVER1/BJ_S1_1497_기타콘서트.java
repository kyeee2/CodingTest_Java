import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_1497_기타콘서트 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N, M; // N: 기타 수, M: 노래 수
	static String [] guitars;
	static boolean [] music;
	static boolean [] isSelected; 
	static int maxMusic, minGuiterCnt = 11;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		guitars = new String[N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			tokens.nextToken(); // <- 기타 이름 버리기
			guitars[i] = tokens.nextToken();
		}
		isSelected = new boolean[N];
		
		combination(0);
		
		System.out.println(minGuiterCnt > 0 ? minGuiterCnt : -1);
		
	}

	private static void combination(int cnt) {
		if(cnt == N) {
			music = new boolean[M];
			
			// 연주 가능한 곡 체크하기
			int cntGuiter = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					cntGuiter++;
					for(int j = 0; j < M; j++) {
						if(guitars[i].charAt(j) == 'Y') {
							music[j] = true;
						}
					}
				}
			}
			// 연주 가능한 곡의 개수
			int cntMusic = 0;
			for(int i = 0; i < M; i++) {
				if(music[i]) cntMusic++;
			}
			
			// 최소한의 기타 개수 체크하기
			if(maxMusic < cntMusic) {
				maxMusic = cntMusic;
				minGuiterCnt = cntGuiter;
			} else if(maxMusic == cntMusic && minGuiterCnt > cntGuiter) { // 여기서 기타의 개수는 비교해주지 않아서 계속 틀림
				minGuiterCnt = cntGuiter;
			}
			
			return;
		}
		
		// 현재 기타를 선택하는 경우
		isSelected[cnt] = true;
		combination(cnt + 1);
		// 현재 기타를 선택하지 않는 경우
		isSelected[cnt] = false;
		combination(cnt + 1);
		
	}

}
