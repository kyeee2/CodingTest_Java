import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_5427_불 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	static int T, N, M, result;
	static int[][] map, fire, person;
	static boolean[][] visited;
	static Queue<Point> fires;
	static Queue<Point> persons;
	static int[] dr = { -1, 0, 1, 0 }, dc = { 0, 1, 0, -1 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			tokens = new StringTokenizer(br.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());

			map = new int[N][M];
			fire = new int[N][M];
			fires = new LinkedList<>();
			person = new int[N][M];
			persons = new LinkedList<>();
			for (int r = 0; r < N; r++) {
				String line = br.readLine();
				for (int c = 0; c < M; c++) {
					map[r][c] = line.charAt(c);
					if (map[r][c] == '@') {
						map[r][c] = '.';
						persons.offer(new Point(r, c));
						person[r][c] = 0;
					} else {
						person[r][c] = -1;
					}
					if (map[r][c] == '*') {
						fire[r][c] = 0;
						fires.offer(new Point(r, c));
					} else {
						fire[r][c] = -1;
					}
				}
			}

			bfsFire();
			result = bfsSang();
			if (result == -1)
				output.append("IMPOSSIBLE\n");
			else
				output.append(result + "\n");
		}
		System.out.println(output);
	}

	// 불 퍼지는 시간 체크
	private static void bfsFire() {
		while (!fires.isEmpty()) {
			Point now = fires.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)	continue;
				if (fire[nr][nc] >= 0 || map[nr][nc] == '#') continue;

				fires.offer(new Point(nr, nc));
				fire[nr][nc] = fire[now.r][now.c] + 1;
			}
		}
	}

	// 상근이가 탈출하는데 걸리는 시간
	private static int bfsSang() {
		while(!persons.isEmpty()) {
			Point now = persons.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) return person[now.r][now.c] + 1;
				if(person[nr][nc] >= 0 || map[nr][nc] == '#') continue;
				if(fire[nr][nc] != -1 && fire[nr][nc] <= person[now.r][now.c] + 1) continue;
				
				persons.add(new Point(nr, nc));
				person[nr][nc] = person[now.r][now.c] + 1;
			}
		}
		
		return -1;
	}

}
