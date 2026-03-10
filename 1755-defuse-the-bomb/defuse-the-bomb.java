class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        
        if(k == 0) return result; // send the result array filled with zeroes only
        
        int start = 1, end = k, sum = 0;
        
        if(k < -k) {
            k = -k;
            start = code.length - k;
            end = code.length - 1;
        }
        
        for(int i = start; i <= end; i++) sum += code[i];
        
        for(int i = 0; i < code.length; i++) {
            result[i] = sum;
            sum -= code[(start++) % code.length];
            sum += code[(++end) % code.length];
        }
        
        return result;
    }
}