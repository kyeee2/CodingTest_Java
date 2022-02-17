import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G4_1987_알파벳 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C, max = -1;
	static char [][] board;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static Set<Character> alps = new HashSet<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		board = new char [R][C];
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		
//		visited = new boolean[R][C];
		alps.add(board[0][0]);
		findMax(0, 0, 1);
		
		System.out.println(max);
	}

	private static void findMax(int r, int c, int cnt) {
		int flag = 0;
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(isin(nr, nc) && !alps.contains(board[nr][nc])) {
				flag++;
				alps.add(board[nr][nc]);
				findMax(nr, nc, cnt+1);
				alps.remove(board[nr][nc]);
			}
		}
		
		if(flag == 0) {
			if(cnt > max) max = cnt;
			return;
		}
	}

	private static boolean isin(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
