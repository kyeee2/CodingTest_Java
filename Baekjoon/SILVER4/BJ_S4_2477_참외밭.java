package bj.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S4_2477_참외밭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int [] rect = new int [6];
		
		int max_x = 0, max_y = 0;
		int max_x_ind = 0, max_y_ind = 0;
		for(int i = 0; i < 6; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(tokens.nextToken());
			int len = Integer.parseInt(tokens.nextToken());
			
			rect[i] = len;
			if(dir == 3 || dir == 4) {
				if(len > max_x) {
					max_x = len;
					max_x_ind = i;
				}				
			} else {
				if(len > max_y) {
					max_y = len;
					max_y_ind = i;
				}
			}
		}
		
		int min_y = rect[(max_x_ind - 1 + 6) % 6] > rect[(max_x_ind + 1) % 6] ? rect[(max_x_ind - 1 + 6) % 6] - rect[(max_x_ind + 1) % 6] : rect[(max_x_ind + 1) % 6] - rect[(max_x_ind - 1 + 6) % 6];
		int min_x = rect[(max_y_ind - 1 + 6) % 6] > rect[(max_y_ind + 1) % 6] ? rect[(max_y_ind - 1 + 6) % 6] - rect[(max_y_ind + 1) % 6] : rect[(max_y_ind + 1) % 6] - rect[(max_y_ind - 1 + 6) % 6];
		
		int sum = (max_x * max_y - min_x * min_y) * K;
		System.out.println(sum);

	}

}