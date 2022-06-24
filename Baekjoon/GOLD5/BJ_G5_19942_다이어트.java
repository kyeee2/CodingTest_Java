import java.io.*;
import java.util.*;

public class BJ_G5_19942_다이어트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output;
	static StringTokenizer tokens;
	
	static int N, minCost = Integer.MAX_VALUE;
	static int [] min;
	static int [][] foods;
	static int [] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		min = new int [4];
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			min[i] = Integer.parseInt(tokens.nextToken());
		}
		
		foods = new int [N][5];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				foods[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i = 1; i <= N; i++) {
			selected = new int [i];
			select(0, 0, i);
		}
		
		if(minCost == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(output);
		}
	}

	private static void select(int start, int idx, int n) {
		if(idx == n) {
			isPosible(n);
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[idx] = i;
			select(i + 1, idx + 1, n);
		}
	}

	private static void isPosible(int n) {
		int cost = 0;
		int [] food = new int [4];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 4; j++) {
				food[j] += foods[selected[i]][j];
			}
			cost += foods[selected[i]][4];
		}
		
		// 최소 영양분 맞췃는지 체크
		for(int i = 0; i < 4; i++) {
			if(min[i] > food[i]) return; 
		}
		
		if(cost < minCost) {
			minCost = cost;
			
			output = new StringBuilder();
			output.append(minCost + "\n");
			for(int i = 0; i < n; i++) {
				output.append((selected[i] + 1) + " ");
			}
		} else if(cost == minCost) {
			StringBuilder temp = new StringBuilder();
			
			temp.append(minCost + "\n");
			for(int i = 0; i < n; i++) {
				temp.append((selected[i] + 1) + " ");
			}
			
			// 사전순으로 가장 빠른것 찾기 
			if(temp.toString().compareTo(output.toString()) < 0) {
				output = new StringBuilder(temp.toString());
			}
		}
	}

}
