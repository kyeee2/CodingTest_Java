import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String number = "";
        
        // k진수로 변환
        while(n > 0) {
            number = (n % k) + number;
            n /= k;
        }
        
        StringTokenizer tokens = new StringTokenizer(number, "0");
        
        int cnt = 0;
        while(tokens.hasMoreTokens()) {
            long num = Long.parseLong(tokens.nextToken());
            
            // 2 이상이고, 소수라면
            if(num >= 2 && isPrime(num)) cnt++;
        }
        
        return cnt;
    }
    
    // 소수인지
    public boolean isPrime(long n) {
        for(long i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}