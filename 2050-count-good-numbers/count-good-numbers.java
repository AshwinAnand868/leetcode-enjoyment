class Solution {
    static final int MOD = 1_000_000_007;

    public long power(long base, long exponent) {
        if(exponent == 0) {
            return 1;
        }

        long result = power(base, exponent / 2);

        if(exponent % 2 == 0) {
            return (result * result) % MOD;
        } else {
            return (result * result * base) % MOD;
        }

        // return ans;

        // while (exponent > 0) {
        //     if (exponent % 2 == 1) {
        //         ans = (ans * base) % MOD;
        //         exponent = exponent - 1;
        //     } else {
        //         base = (base * base) % MOD;
        //         exponent = exponent / 2;
        //     }
        // }

        // return ans;
    }

    public int countGoodNumbers(long n) {
        long evenProp = (n + 1) / 2;
        long oddProp = n / 2;

        long result = (power(5, evenProp) * power(4, oddProp)) % MOD;

        return (int) result;
    }
}
