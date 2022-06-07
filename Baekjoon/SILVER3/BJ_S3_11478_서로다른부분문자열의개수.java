import java.io.*;
import java.util.*;

public class BJ_S3_11478_서로다른부분문자열의개수 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String word = br.readLine();
		Set<String> words = new HashSet<>();
		
		for(int i = 0; i < word.length(); i++) {
			for(int j = i; j < word.length(); j++) {
				words.add(word.substring(i, j + 1));
			}
		}
		
		System.out.println(words.size());
	}

}