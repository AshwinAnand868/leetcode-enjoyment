class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        boolean[] answers = new boolean[queries.length];
        
        int[] converted = new int[nums.length];
        converted[0] = 0;
        
        for(int i = 1, j = 0; i < nums.length; ++i) {
            if(nums[i] % 2 == nums[i - 1] % 2) j++;
            converted[i] = j;
        }
        
        for(int i = 0; i < queries.length; ++i) {
            answers[i] = converted[queries[i][0]] == converted[queries[i][1]];
        }
        
        return answers;
        
        
//         boolean isPairSpecial = false;
        
//         for(int k = 0; k < queries.length; k++) {
//             int firstIndex = queries[k][0];
//             int lastIndex = queries[k][1];
            
//             if(firstIndex != lastIndex) {
//                 for(int f = firstIndex; f <= lastIndex; f++) {
                    
//                     if(f + 1 > lastIndex) {
//                         break;
//                     }
//                     int sum = nums[f] + nums[f+1];                    
                  
//                     isPairSpecial = sum % 2 != 0;

//                     if(!isPairSpecial) 
//                         break;
//                 }
//             } else {
//                 isPairSpecial = true;
//             }
            
            
//             if(isPairSpecial) {
//                 answers[k] = true;
//             } else {
//                 answers[k] = false;
//             }
//         }
        
//         return answers;

    }
    
}