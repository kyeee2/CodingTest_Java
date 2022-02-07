import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S2_2004_조합0의개수 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] line = br.readLine().split(" ");
		
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		if(m > n / 2) {
			m = n - m;
		}
		
		int cntTwo = countNum(n, 2); // 2의 개수
		cntTwo -= countNum(m, 2);
		cntTwo -= countNum(n - m, 2);
		
		int cntFive = countNum(n, 5); // 5의 개수
		cntFive -= countNum(m, 5);
		cntFive -= countNum(n - m, 5);
		
		System.out.println(Math.min(cntTwo, cntFive));
	}

	private static int countNum(int n, int g) {
//		int cnt = 0;
		
		/*
		 * 시간초과 코드
		 * */
		/*
		for(int i = end; i <= start; i++) {
			int num = i;
			
			while(num > 1 && num % g == 0) {
				num /= g;
				cnt++;
			}
		}
		*/
		int cnt = 0;
		
		while(n > 0) {
			cnt += n / g;
			n /= g;
		}
		
		return cnt;
	}

}
