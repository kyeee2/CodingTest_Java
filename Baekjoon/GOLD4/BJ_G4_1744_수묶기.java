import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ_G4_1744_수묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> pos = new ArrayList<>();
		List<Integer> neg = new ArrayList<>();
		boolean zero = false;
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num > 0) {
				pos.add(num);
			} else if(num < 0) {
				neg.add(num);
			} else {
				zero = true;
			}
		}
		
		Collections.sort(pos);
		Collections.sort(neg);
		
		int sum = 0;
		for(int i = pos.size() - 1; i > (pos.size() % 2 == 0 ? 0: 1); i-=2) {
			if(pos.get(i) == 1 || pos.get(i - 1)== 1) {
				sum += pos.get(i) + pos.get(i - 1);
			} else {
				sum += pos.get(i) * pos.get(i - 1);
			}
		}
		for(int i = 0; i < neg.size() - (neg.size() % 2 == 0 ? 1 : 2); i+=2) {
			sum += neg.get(i) * neg.get(i + 1);
		}
		
		if(zero) {
			if(pos.size() % 2 != 0) {
				sum += pos.get(0);
			}
		} else {
			if(neg.size() % 2 != 0) {
				sum += neg.get(neg.size() - 1);
			}
			if(pos.size() % 2 != 0) {
				sum += pos.get(0);
			}
		}
		
		System.out.println(sum);

	}

}
