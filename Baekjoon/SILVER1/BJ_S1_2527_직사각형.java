package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2527_직사각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {

		for(int t = 0; t < 4; t++) {
			tokens = new StringTokenizer(br.readLine());
			
			Square s1 = new Square(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
			Square s2 = new Square(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
		
			if(s1.maxX < s2.minX || s1.minX > s2.maxX || s1.maxY < s2.minY || s1.minY > s2.maxY) { // 공통부분 없음
				output.append('d').append('\n');
			} else if((s1.minX == s2.maxX && s1.minY == s2.maxY)
					|| (s1.maxX == s2.minX && s1.maxY == s2.minY)
					|| (s1.minX == s2.maxX && s1.maxY == s2.minY)
					|| (s1.maxX == s2.minX && s1.minY == s2.maxY)) { // 점
				output.append('c').append('\n');
			} else if(s1.maxX == s2.minX || s1.minX == s2.maxX || s1.maxY == s2.minY || s1.minY == s2.maxY) { // 선
				output.append('b').append('\n');
			} else {
				output.append('a').append('\n');
			}
		}
		
		System.out.println(output);
		
	}
	
	static class Square {
		int minX, minY, maxX, maxY;

		public Square(int x1, int y1, int x2, int y2) {
			if(x1 > x2) {
				minX = x2;
				maxX = x1;
			} else {
				minX = x1;
				maxX = x2;
			}
			
			if(y1 > y2) {
				minY = y2;
				maxY = y1;
			} else {
				minY = y1;
				maxY = y2;
			}
		}
	}
}
