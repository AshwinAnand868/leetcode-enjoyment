import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
//         int aint = binaryToInt(a);
//         int bint = binaryToInt(b);
        
//         int result = aint + bint;
//         System.out.println(result);
//         String resultStr = intToBinary(result);  
        
//         if(resultStr.isEmpty()) {
//             resultStr = "0";
//         }
        
        // Using BigInteger
        // Convert binary strings to BigIntegers
        BigInteger aBig = new BigInteger(a, 2);
        BigInteger bBig = new BigInteger(b, 2);
        
        // Add the two BigIntegers
        BigInteger result = aBig.add(bBig);
        
        // Convert the result back to a binary string
        return result.toString(2);
    }
    
    
//     public String intToBinary(int num) {
//         StringBuilder sb = new StringBuilder();
        
//         while(num > 0) {
//             sb.append(num % 2);
//             num = num / 2;
//         }
        
//         return sb.reverse().toString();
//     }
    
//     public int binaryToInt(String binary) {
//         int binLength = binary.length();
//         int result = 0;
        
//         for(int i = 0; i < binLength; i++) {
//            if(binary.charAt(binLength - 1 - i) == '1') {
//                 result += 1 << i;
//            }
//         }
        
//         return result;
//     }
}