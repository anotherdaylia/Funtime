package com.lia.HashMap;

/**
 * Description:
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Created by liqu on 4/19/16.
 */
public class CountPrimes_204 {

    // The Sieve of Eratosthenes
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];

        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }

        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for(int i = 2; i * i < n; i++) {
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n; j = j + i) {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]) count++;
        }

        return count;
    }
}
