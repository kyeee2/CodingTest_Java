import java.io.*;
import java.util.*;

public class BJ_S2_4358_생태학 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	static int cnt;
	static Map<String, Integer> trees = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		while(true) {
			String tree = br.readLine();
			if(tree == null || tree.equals("")) break;
			
			cnt++;
			if(trees.containsKey(tree)) {
				trees.put(tree, trees.get(tree) + 1);
			} else {
				trees.put(tree, 1);
			}
		}
		
		for(String tree: trees.keySet()) {
			output.append(tree + " " + String.format("%.4f\n", (double)trees.get(tree) / (double)cnt * 100.));
		}
		System.out.println(output);
	}

}
