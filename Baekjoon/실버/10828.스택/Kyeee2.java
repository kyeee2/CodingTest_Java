package algorithm_me;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kyeee2 {
	
	static final int MAX_VALUE = 10000;
	static int [] stack;
	static int top = -1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		stack = new int[MAX_VALUE];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			
			switch(tokens.nextToken()) {
			case "push":
				int n = Integer.parseInt(tokens.nextToken());
				push(n);
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(size());
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}
		}
		
	}
	
	private static void push(int n) {
		if(top == MAX_VALUE) {
			return;
		}
		
		stack[++top] = n;
	}
	
	private static int pop() {
		if(empty() == 1) {
			return -1;
		}
		
		return stack[top--];
	}
	
	private static int size() {
		return top + 1;
	}
	
	private static int empty() {
		if(top == -1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private static int top() {
		if(empty() == 1) {
			return -1;
		}
		
		return stack[top];
	}

}
