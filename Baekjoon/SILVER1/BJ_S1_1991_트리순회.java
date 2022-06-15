import java.io.*;
import java.util.*;

public class BJ_S1_1991_트리순회 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	static int N;
	static List<List<Node>> graph = new ArrayList<>();
	
	static class Node {
		int left, right;
		
		public Node(int l, int r) {
			this.left = l;
			this.right = r;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(br.readLine());
			int node = tokens.nextToken().charAt(0) - 'A' + 1;
			int left = tokens.nextToken().charAt(0) - 'A' + 1;
			int right = tokens.nextToken().charAt(0) - 'A' + 1;
			
			graph.get(node).add(new Node(left, right));
		}
		
		preOrder(1);
		output.append("\n");
		inOrder(1);
		output.append("\n");
		postOrder(1);
		
		System.out.println(output);
	}

	private static void preOrder(int now) {
		int l = graph.get(now).get(0).left;
		int r = graph.get(now).get(0).right;
		
		output.append((char)(now + 'A' - 1));
		if(l != -18) preOrder(l);
		if(r != -18) preOrder(r);
	}

	private static void inOrder(int now) {
		int l = graph.get(now).get(0).left;
		int r = graph.get(now).get(0).right;
		
		if(l != -18) inOrder(l);
		output.append((char)(now + 'A' - 1));
		if(r != -18) inOrder(r);
	}

	private static void postOrder(int now) {
		int l = graph.get(now).get(0).left;
		int r = graph.get(now).get(0).right;
			
		if(l != -18) postOrder(l);
		if(r != -18) postOrder(r);
		output.append((char)(now + 'A' - 1));
	}

}
