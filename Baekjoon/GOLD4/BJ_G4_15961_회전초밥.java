import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_15961_회전초밥 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, D, K, C, max = -1;
	static int [] dishes;
	static int [] selected;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 접시의 수
		D = Integer.parseInt(tokens.nextToken()); // 초밥의 가짓수
		K = Integer.parseInt(tokens.nextToken()); // 연속해서 먹는 접시의 수
		C = Integer.parseInt(tokens.nextToken()); // 쿠폰 번호
		
		dishes = new int [N];
		for(int i = 0; i < N; i++) {
			dishes[i] = Integer.parseInt(br.readLine());
		}
		
		selected = new int [D + 1]; // 초밥 종류 - 먹은 개수
		selected[C]++;
		int cnt = 1; // 현재 먹은 초밥 종류 개수
		for(int i = 0; i < K; i++) {
			if(selected[dishes[i]] == 0) cnt++; // 처음 먹는 종류라면 개수 증가
			selected[dishes[i]]++;
		}
		max = Math.max(max, cnt);
		
		int start = 1, end = K;
		while(start != 0) {
			if(selected[dishes[end]] == 0) cnt++;
			selected[dishes[end]]++;
			
			if(selected[dishes[start - 1]] == 1) cnt--;
			selected[dishes[start - 1]]--;
			
			max = Math.max(max, cnt);
			start = (start + 1) % N;
			end = (end + 1) % N;
		}
		
		System.out.println(max);
		
	}

}
