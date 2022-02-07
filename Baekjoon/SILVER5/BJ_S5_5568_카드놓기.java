import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_S5_5568_카드놓기 {
	
	static int n, k;
	static String [] kards;
	static boolean [] ch;
	static int [] result;
	static Set<String> nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		kards = new String[n];
		for(int i = 0; i < n; i++) {
			kards[i] = br.readLine();
		}
		ch = new boolean[n];
		nums = new HashSet<>();
		
		permutation(0, "");
		
		System.out.println(nums.size());
	}

	private static void permutation(int cnt, String num) {
		if(cnt == k) {
			nums.add(num);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!ch[i]) {
				num += kards[i];
				ch[i] = true;
				permutation(cnt + 1, num);
				ch[i] = false;
				num = num.substring(0, num.length() - kards[i].length());
			}
		}
	}

}
