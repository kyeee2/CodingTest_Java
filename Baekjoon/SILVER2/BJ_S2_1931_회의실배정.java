import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens;
		
		int N = Integer.parseInt(br.readLine());
		int [][] rooms = new int [N][2];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			
			rooms[i][0] = Integer.parseInt(tokens.nextToken());
			rooms[i][1] = Integer.parseInt(tokens.nextToken());
		}
		
		// 회의가 끝나는 시간으로 오름차순 정렬, 같으면 시작 시간으로 오름차순 정렬
		Arrays.sort(rooms, (r1, r2) -> {
			if(r1[1] == r2[1]) {
				return Integer.compare(r1[0], r2[0]);
			} else {
				return Integer.compare(r1[1], r2[1]);
			}
		});

		int cnt = 1;
		int endTime = rooms[0][1];
		for(int i = 1; i < N; i++) {
			if(rooms[i][0] >= endTime) {
				endTime = rooms[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
