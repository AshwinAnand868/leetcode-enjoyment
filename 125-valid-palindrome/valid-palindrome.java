class Solution {
    public boolean isPalindrome(String s) {

        // Approach - 1
        // Checking edge cases

        if(s == null || s.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while(start <= end) {
            char currFirst = s.charAt(start);
            char currEnd = s.charAt(end);

            if(!Character.isLetterOrDigit(currFirst)) {
                start++;
            }

            if(!Character.isLetterOrDigit(currEnd)) {
                end--;
            }

            if(Character.isLetterOrDigit(currFirst) && Character.isLetterOrDigit(currEnd)) {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currEnd)) {
        			return false;
        		}

                start++;
                end--;
            }


        }

        return true;

        // Approach - 2
        // StringBuilder sb = new StringBuilder();

        // for(char c : s.toCharArray()) {
        //     if(Character.isLetterOrDigit(c)) {
        //         sb.append(c);
        //     }
        // }

        // StringBuilder reversed = new StringBuilder(sb.toString().toLowerCase());
        // reversed.reverse();

        // return sb.toString().toLowerCase().equals(reversed.toString());

        // Approach 3
        // String cleanString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // StringBuilder sb = new StringBuilder(cleanString).reverse();

        // return cleanString.equals(sb.toString());

    }
}