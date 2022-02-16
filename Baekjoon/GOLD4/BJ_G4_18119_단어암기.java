import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G4_18119_단어암기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N, M, alp; // alp: 전체 알파벳의 비트
	static String [] words; // 영어 단어
	static int [] wordBits; // 영어 단어의 알파벳을 가진 비트들
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		words = new String [N];
		wordBits = new int [N];
		for(int i = 0; i < N; i++) {
			words[i] = br.readLine();
			for(int j = 0; j < words[i].length(); j++) {
				wordBits[i] |= 1 << (words[i].charAt(j) - 'a');
				alp |= 1 << (words[i].charAt(j) - 'a');
			}
		}

		for(int t = 1; t <= M; t++) {
			tokens = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(tokens.nextToken());
			int n = tokens.nextToken().charAt(0) - 'a';
			if(command == 1) {
				alp ^= 1 << n; // 해달 알파벳 비트 0으로
			} else {
				alp |= 1 << n; // 해당 알파벳 비트 1로
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if((alp & wordBits[i]) == wordBits[i]) { // 전체 알파벳의 비트에 i번째 알파벳 비트 존재하는가
					cnt++;
				}
			}
			
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);

	}

}
