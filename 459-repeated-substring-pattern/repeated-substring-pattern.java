class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for(int l = 1; l <= (n / 2); ++l) {
            if(n % l == 0) {
                int times = n / l; // times the nested loop will run
                String currentSub = s.substring(0, l);
                StringBuilder appendedString = new StringBuilder("");

                while(times > 0) {
                    appendedString.append(currentSub);
                    times--;
                }

                if(appendedString.toString().equals(s)) {  // Fix here
                    return true;
                }

            }
        }
        return false;
    }
}