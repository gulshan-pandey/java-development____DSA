package DSA;

public class CountPrimes {
    
}






class Solution {        //sieve of erathosenes
    public int countPrimes(int n) {  
        boolean[] isPrime = new boolean[n];  
        for (int i = 2; i < n; i++) {  
            isPrime[i] = true;  
        }  
    
        for (int i = 2; i * i < n; i++) {  
            if (!isPrime[i]) {  
                continue;  
            }  
            for (int j = i * i; j < n; j += i) { // Start from i * i instead of i  
                isPrime[j] = false;  
            }  
        }  
    
        int count = 0;  
        for (int i = 2; i < n; i++) {  
            if (isPrime[i]) {  
                count++;  
            }  
        }  
    
        return count;  
    }  
}