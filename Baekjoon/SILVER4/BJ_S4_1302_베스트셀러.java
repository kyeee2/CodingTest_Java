import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BJ_S4_1302_베스트셀러 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static Map<String, Integer> books = new TreeMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String book = br.readLine();
			
			if(books.containsKey(book)) {
				books.put(book, books.get(book) + 1);
			} else {
				books.put(book, 1);
			}
		}
		
		int max = 0;
		String book = "";
		for(String b: books.keySet()) {
			if(books.get(b) > max) {
				max = books.get(b);
				book = b;
			}
		}
		
		System.out.println(book);
	}

}
