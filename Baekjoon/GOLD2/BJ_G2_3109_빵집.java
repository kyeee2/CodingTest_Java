import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_G2_3109_빵집 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int R, C, cnt;
	static char [][] map;
	static boolean [][] ch;
	static int [][] d = {{-1, 1}, {0, 1}, {1, 1}}; // 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
	
	public static void main(String[] args) throws IOException {
		
		tokens = new StringTokenizer(br.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		ch = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			String row = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = row.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			solution(r, 0);
		}
		
		System.out.println(cnt);

	}

	private static boolean solution(int r, int c) {
		// 현재 행의 파이프를 끝까지 놓을 수 있다면
		if(c == C - 1) {
			cnt++;
			return true;
		}
	
		for(int i = 0; i < 3; i++)  {
			int nr = r + d[i][0];
			int nc = c + d[i][1];
			
			if(isPosible(nr, nc) && !ch[nr][nc] && map[nr][nc] == '.') {
				ch[nr][nc] = true;
				if(solution(nr, nc)) return true;
			}
		}
		
		return false;
	}
	
	private static boolean isPosible(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

}
