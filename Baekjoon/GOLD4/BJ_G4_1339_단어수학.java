import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_G4_1339_단어수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer [] alps = new Integer[26];
		Arrays.fill(alps, 0);
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			int p = 1;
			for(int j = word.length() - 1; j >= 0 ; j--) {
				alps[word.charAt(j) - 'A'] += p;
				p *= 10;
			}
		}
		
		Arrays.sort(alps, (a1, a2) -> Integer.compare(a1, a2) * -1);

		int sum = 0;
		for(int i = 0, j = 9; i < 26; i++, j--) {
			if(alps[i] == 0) break;
			
			sum += alps[i] * j;
		}
		
		System.out.println(sum);
		
	}

}
