class Solution {
    public int[] productExceptSelf(int arr[]) {
        int totalProdWithOutZero = 1;
        int zeroes = 0;
        int idx = -1;
        int n = arr.length;
        
        int[] res = new int[arr.length];
        
        for(int i = 0; i < n; ++i) {
            if(arr[i] == 0) {
                zeroes++;
                idx = i;
            } else {
                totalProdWithOutZero *= arr[i];
            }
        }
        
        Arrays.fill(res, 0);

        if (zeroes == 0) {
            for (int i = 0; i < n; i++) 
                res[i] = totalProdWithOutZero / arr[i];
        }
        else if (zeroes == 1)
            res[idx] = totalProdWithOutZero;
        
        return res;
    }
}