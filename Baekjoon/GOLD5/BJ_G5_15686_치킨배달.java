package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15686_치킨배달 {

	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M, minDir = Integer.MAX_VALUE;
	static int [] p;
	static List<Point> homes = new ArrayList<>(); // 집 좌표
	static List<Point> stores = new ArrayList<>(); // 치킨집 좌표
	static int [] selected;
	
	public static void main(String[] args) throws IOException {

		
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				int num = tokens.nextToken().charAt(0) - '0';
				
				if(num == 1) {
					homes.add(new Point(r, c));
				} else if(num == 2) {
					stores.add(new Point(r, c));
				}
			}
		}
		
		selected = new int [M]; // M개의 치킨집 선책 
		
		selectChiken(0, 0);
		
		System.out.println(minDir);
		
	}
	
	// M개의 치킨집을 선택
	private static void selectChiken(int cnt, int start) {
		if(cnt == M) {
			minDir = Math.min(minDir, calcMin());
			return;
		}
		
		for(int i = start; i < stores.size(); i++) {
			selected[cnt] = i;
			selectChiken(cnt + 1, i + 1);;
		}
	}

	// 선택된 치킨집과 집들의 거리의 합
	private static int calcMin() {
		int sum = 0;
		
		for(int i = 0; i < homes.size(); i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 0; j < M; j++) {
				int dir = Math.abs(homes.get(i).r - stores.get(selected[j]).r) + Math.abs(homes.get(i).c - stores.get(selected[j]).c);
				min = Math.min(min, dir);
			}
			
			sum += min;
			if(sum > minDir) return Integer.MAX_VALUE; // 이미 최소값을 넘었다면 이 경우는 버리기
		}
		
		return sum;
	}
}
