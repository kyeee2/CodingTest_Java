import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S2_1780_종이의개수 {
	 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static int [][] paper;
	static int [] count = new int [3]; // -1, 0, 1 의 개수

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		paper = new int [N][N];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		countPaper(0, 0, N);
		
		output.append(count[0] + "\n").append(count[1] + "\n").append(count[2] + "\n");
		System.out.println(output);
	}

	private static void countPaper(int R, int C, int size) {
		if(size == 1) {
			count[paper[R][C] + 1]++;
			return;
		}
		
		boolean flag = true; // 색종이를 자를 수 있는가?
		for(int r = R; r < R + size; r++) {
			for(int c = C; c < C + size; c++) {
				if(paper[r][c] != paper[R][C]) {
					flag = false;
					break;
				}
			}
		}
		if(flag) { // 색종이를 자를 수 있다면
			count[paper[R][C] + 1]++;
			return;
		}
		
		for(int r = R; r < R + size; r += size / 3) {
			for(int c = C; c < C + size; c += size / 3) {
				countPaper(r, c, size / 3);
			}
		}
	}

}
