import java.io.*;
import java.util.*;

public class BJ_S3_1269_대칭차집합 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	static int N, M;
	static Set<Integer> A = new TreeSet<>();
	static Set<Integer> B = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A.add(Integer.parseInt(tokens.nextToken()));
		}

		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B.add(Integer.parseInt(tokens.nextToken()));
		}
		
		int cnt = 0;
		for(int a: A) {
			if(!B.contains(a)) cnt++;
		}
		for(int b: B) {
			if(!A.contains(b)) cnt++;
		}
		
		System.out.println(cnt);
	}

}
