import java.io.FileNotFoundException;
import java.util.Scanner;

public class BJ_S3_2615_오목 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(System.in);
		
		int [][] dirs = {{0, 1}, {1, 1}, {1, 0}, {-1,1}}; // 바둑알 방향
		int [][] map = new int[20][20]; // 1 부터 시작
		
		// 바둑판 입력
		for(int r = 1; r < 20; r++) {
			for(int c = 1; c < 20; c++) {
				map[r][c] = scan.nextInt();
			}
		}
		
		int result = 0; // 결과
		int [] point = new int[2]; // 가장 왼쪽에 있는 바둑알의 좌표
		
		outer : for(int r = 1; r < 20; r++) {
			for(int c = 1; c < 20; c++) {
				if(map[r][c] == 0) continue; // 비었다면 건너띄기

				dir : for(int i = 0; i < 4; i++) { // 방향
					int cnt = 1; // 바둑알의 개수
					int nr = r;
					int nc = c;

					// 이전 돌이 같은가?
					nr = r - dirs[i][0];
					nc = c - dirs[i][1];
					if(1 <= nr && nr <= 19 && 1 <= nc && nc <= 19 && map[nr][nc] == map[r][c]) {
						continue;
					}
					
					nr = r;
					nc = c;
					// 해당 방향으로 5번 전진
					for(int n = 1; n < 5; n++) {
						nr += dirs[i][0];
						nc += dirs[i][1];
						
						if(1 <= nr && nr <= 19 && 1 <= nc && nc <= 19 && map[nr][nc] == map[r][c]) {
							cnt++;
//							System.out.println(nr + ", " + nc + " 에 " + map[r][c] +"돌 " + cnt +"번 찾음!");
						} else {
							continue dir;
						}
					} // end for n~
					
					// 6번 연속인가?
					nr = r + 5 * dirs[i][0];
					nc = c + 5 * dirs[i][1];
					if(1 <= nr && nr <= 19 && 1 <= nc && nc <= 19 && map[nr][nc] == map[r][c]) {
						continue;
					}
					
					result = map[r][c];
					point[0] = r;
					point[1] = c;
					break outer; // outer 빠져나오기
				} // end for i~
			} // end for c~
		} // end outer
		
		// 결과 출력
		if(result == 0) {
			System.out.println(0);
		} else {
			System.out.println(result);
			System.out.println(point[0] + " " + point[1]);
		}
		
		scan.close();
	}

}
