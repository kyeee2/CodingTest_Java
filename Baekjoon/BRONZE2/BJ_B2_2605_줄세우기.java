package bj.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_B2_2605_줄세우기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder outer = new StringBuilder();
	
	static int N;
	static List<Integer> lists = new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int ind = i - Integer.parseInt(tokens.nextToken());
			
			lists.add(ind, i + 1);
		}
		
		for(int num: lists) {
			outer.append(num).append(" ");
		}
		
		System.out.println(outer);
	}

}
