class Solution {
    
    // TLE
    // private boolean isPrime(int num) {  
    //     int sqrtN = (int) Math.floor(Math.sqrt(num)); // or i * i <= num
    //     for(int factor = 2; factor <= sqrtN; ++factor) {
    //         if(num % factor == 0) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int nonPrimeCount = 2;

        isPrime[0] = false;
        isPrime[1] = false;

        int sqrtN = (int) Math.sqrt(n);
        int primeCount = n - 2; // initially

        for(int i = 2; i <= sqrtN; ++i) {
            if(isPrime[i]) {
                // if the number is prime, then its factors will not be prime
                for(int series = 2; i * series < n; ++series) {
                    if(isPrime[i * series]) {
                        isPrime[i * series] = false; // mark the factors as not prime
                        primeCount--;
                    }
                    
                }
            }
        }

        // for(int i = 0; i < isPrime.length; ++i) {
        //     if(isPrime[i]) {
        //         count++;
        //     }
        // }

        return primeCount;
    }
}