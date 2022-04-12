import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_9760_PokerGame {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int T;
	static int [] R, S;
	static String s = "SDHC";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		TC: for(int t = 1; t <= T; t++) {
			output.append("#" + t + " ");
			
			R = new int [14];
			S = new int[4];
			
			tokens = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++) {
				String card = tokens.nextToken();
				int num = findLank(card);
				// 슈트 리스트에 넣기
				S[s.indexOf(card.charAt(0))]++;
				// 랭크 리스트에 넣기
				R[num]++;
			}

			// 슈트 리스트로 찾아주기
			for(int i = 0; i < 4; i++) {				
				if(S[i] == 5) {
					 if(isStraight()) output.append("Straight Flush\n");
					 else     		  output.append("Flush\n");
					 continue TC;
				}
			}
			
			// 랭크 리스트로 찾아주기
			if(isStraight()) {
				output.append("Straight\n");
				continue;
			}
			
			int two = 0, three = 0, four = 0;
			for(int i = 1; i <= 13; i++) {
				if(R[i] == 4) four++;
				if(R[i] == 3) three++;
				if(R[i] == 2) two++;
			}
			
			if(four == 1) {
				output.append("Four of a Kind\n");
				continue;
			}
			if(two == 2) {
				output.append("Two pair\n");
				continue;
			}
			if(three == 1 && two == 1) {
				output.append("Full House\n");
				continue;
			}
			if(three == 1) {
				output.append("Three of a kind\n");
				continue;
			}
			if(two == 1) {
				output.append("One pair\n");
				continue;
			}
			
			output.append("High card\n");
		}
		
		System.out.println(output);
	}
	
	// 카드 번호 찾아주기
	private static int findLank(String card) {
		char num = card.charAt(1);
		if('2' <= num && num <= '9') return num - '0';
		switch(num) {
		case 'A': return 1;
		case 'T': return 10;
		case 'J': return 11;
		case 'Q': return 12;
		case 'K': return 13;
		}
		
		return 0;
	}

	private static boolean isStraight() {
        boolean straight = false;

        for (int i = 1; i < R.length - 4; i++) {
            // 랭크의 범위 내에서 5개가 연속일 경우
            if (R[i] == R[i + 1] && R[i] == R[i + 2] && R[i] == R[i + 3] && R[i] == R[i + 4] && R[i] == 1)
                straight = true;
        }

        // 랭크의 범위 내에서 로얄플러시-숫자 연속일 경우
        if (R[1] == R[10] && R[1] == R[11] && R[1] == R[12] && R[1] == R[13] && R[1] == 1)
            straight = true;
        
        return straight;
	}
}
