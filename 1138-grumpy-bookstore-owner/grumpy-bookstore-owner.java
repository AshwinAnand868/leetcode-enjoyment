class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int nUnsatisfied = 0;
        int satisfiedCustomers = 0;
        int n = customers.length;
        int maxUnsatisfied = 0;

        int i = 0, j = 0;

        // Sliding window to find the max extra satisfied customers
        while (j < n) {
            if (grumpy[j] == 1) {
                nUnsatisfied += customers[j];
            }

            while ((j - i + 1) > minutes) {
                if (grumpy[i] == 1) {
                    nUnsatisfied -= customers[i];
                }
                i++;
            }

            maxUnsatisfied = Math.max(maxUnsatisfied, nUnsatisfied);
            j++;
        }

        // Compute customers already satisfied (when not grumpy)
        for (int k = 0; k < n; k++) {
            if (grumpy[k] == 0) {
                satisfiedCustomers += customers[k];
            }
        }

        return satisfiedCustomers + maxUnsatisfied;
    }
}