class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int l = 1; l < n; ++l) {
            if(n % l == 0) {
                int times = n / l;

                String currentSub = s.substring(0, l);
                StringBuilder appendedString = new StringBuilder("");

                while(times > 0) {
                    appendedString.append(currentSub);
                    times--;
                }

                if(appendedString.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }
}