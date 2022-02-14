package bj.s1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2961_도영이가만든맛있는음식 {
	static long[] Sour; // 신맛
	static long[] Bitter; // 쓴맛

	static ArrayList<Long> totalSour = new ArrayList<Long>(); // 총 신맛
	static ArrayList<Long> totalBitter = new ArrayList<Long>(); // 총 쓴맛

	static int N, S, B; // 재료 수, 신맛 , 쓴맛
	static long minSub = -1; // 신맛-쓴맛의 최소값
	static boolean[] visited;

	static ArrayList<int[]> arr = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Sour = new long[N];
		Bitter = new long[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Sour[i] = Integer.parseInt(st.nextToken());
			Bitter[i] = Integer.parseInt(st.nextToken());

		}

		powerSet(Sour, visited, N, 0, 1);
		powerSet(Bitter, visited, N, 0, 0);
		
		getSub(totalSour, totalBitter);
		System.out.println(minSub);
	}

	static void powerSet(long[] arr, boolean[] visited, int n, int idx, int isSour) {
		if (idx == n) {
			getArr(arr, visited, n, isSour);
			return;
		}

		// 선택 X
		visited[idx] = false;
		powerSet(arr, visited, n, idx + 1, isSour);
		// 선택 O
		visited[idx] = true;
		powerSet(arr, visited, n, idx + 1, isSour);
	}

	static void getArr(long[] arr, boolean[] visited, int n, int isSour) {
		S = 1;
//		visited[0] = false;
		for (int i = 0; i < n; i++) {
			if (visited[i] == true && isSour == 1) {
				// 신맛 : 신 * 신
				S *= Sour[i];
			} else if (visited[i] == true && isSour == 0) {
				// 쓴 맛 : 쓴 + 쓴
				B += Bitter[i];
			}
		}
	}

	static void getSub(ArrayList<Long> Sour, ArrayList<Long> Bitter) {
		long Sub;
		/* 주의 : 인덱스 0은 '공집합'이므로 index = 1부터 돌자 */
		for (int i = 1; i < Sour.size(); i++) {
			for (int j = 1; j < Sour.size(); j++) {
				Sub = (Sour.get(i) > Bitter.get(j)) ? Sour.get(i) - Bitter.get(j) : Bitter.get(j) - Sour.get(i); // 양수값만들기

				if (minSub == -1) {
					minSub = Sub; // 최소값 저장 (최초)
				} else if (minSub > Sub) {
					minSub = Sub;
				}

			}
		}

	}
}