import java.util.Scanner;

public class BJ_S5_2609_최대공약수와최소공배수 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		
		int g = gcd(n1, n2);
		int l = g * (n1 / g) * (n2 / g);
		
		System.out.println(g);
		System.out.println(l);
		
		scan.close();

	}

	private static int gcd(int n1, int n2) {
		if(n1 % n2 == 0) {
			return n2;
		} else {
			return gcd(n2, n1 % n2);
		}
	}

}
