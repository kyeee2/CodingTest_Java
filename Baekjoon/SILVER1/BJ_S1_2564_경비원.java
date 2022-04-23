import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int R, C, N;
	static Point [] stores;
	static Point sec;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(br.readLine());
		
		stores = new Point[N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			stores[i] = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), R, C);
		}
		tokens = new StringTokenizer(br.readLine());
		sec = new Point(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), R, C);
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sec.dir + stores[i].dir == 3) { // 북과 남
				sum += Math.abs(sec.c - stores[i].c);
				if(sec.c > stores[i].c) {
					sum += 2 * Math.min(stores[i].c, C - sec.c);
				} else {
					sum += 2 * Math.min(C - stores[i].c, sec.c);
				}
				sum += R;
			} else if(sec.dir + stores[i].dir == 7) { // 서와 동
				sum += Math.abs(sec.r - stores[i].r);
				if(sec.r > stores[i].r) {
					sum += 2 * Math.min(stores[i].r, R - sec.r);
				} else {
					sum += 2 * Math.min(R - stores[i].r, sec.r);
				}
				sum += C;
			} else {
				sum += Math.abs(sec.c - stores[i].c);
				sum += Math.abs(sec.r - stores[i].r);
			}
		}
		
		System.out.println(sum);
	}

}

class Point {
	int dir, r, c;
	
	public Point(int dir, int n, int R, int C) {
		this.dir = dir;
		switch(dir) {
		case 1: // 북
			this.r = 0;
			this.c = n;
			break;
		case 2: // 남
			this.r = R;
			this.c = n;
			break;
		case 3: // 서
			this.r = n;
			this.c = 0;
			break;
		case 4: // 동
			this.r = n;
			this.c = C;
			break;
		}
	}
	
}