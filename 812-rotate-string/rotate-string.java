class Solution {

    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        // If the lengths are not equal, they can't be rotations
        if (m != n) {
            return false;
        }

        // Check all possible rotations
        for (int rotationCount = 1; rotationCount <= m; ++rotationCount) {
            // Perform one rotation by shifting left by one character
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }


    // public boolean rotateString(String s1, String s2) {
    //     if (s1.length() != s2.length()) {
    //         return false;
    //     }

    //     if(s1.equals(s2)) return true;

    //     StringBuilder temp = new StringBuilder(s1);

    //     for (int i = 0; i < s1.length(); i++) {
    //         temp.deleteCharAt(0);
    //         temp.append(s1.charAt(i));
    //         if (temp.toString().equals(s2)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public void reverse(int start, int end, StringBuilder given) {
    // while (start < end) {

    // char temp = given.charAt(end);
    // given.setCharAt(end, given.charAt(start));
    // given.setCharAt(start, temp);

    // start++;
    // end--;
    // }
    // }

    // public boolean rotateString(String s, String goal) {
    // int n = s.length();

    // if(s.equals(goal)) return true;

    // for(int i = 1; i < s.length(); ++i) {
    // StringBuilder given = new StringBuilder(s);
    // reverse(n - i, n - 1, given);
    // reverse(0, n - i - 1, given);
    // reverse(0, n - 1, given);

    // if(given.toString().equals(goal)) {
    // return true;
    // }
    // }

    // return false;
    // }
}