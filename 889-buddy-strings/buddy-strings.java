class Solution {

    public boolean checkFrequency(String s) {
        int[] counters = new int[26];

        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);
            counters[curr - 'a']++;

            if(counters[curr - 'a'] > 1) {
                return true;
            }
        }

        return false;
    }

    public boolean buddyStrings(String s, String goal) {

        // if the length of both s and goal is not equal, then there is no way these can be buddies
        if(s.length() != goal.length()) {
            return false;
        }

        // if s is already equal to goal, then check if there exists
        // two same characters that can be swapped without changing
        // the actual value of the string
        if(s.equals(goal)) {
           return checkFrequency(s);
        }

        List<Integer> indices = new ArrayList<>();

        // check how many indices in both the strings are not equal
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) != goal.charAt(i)) {
                indices.add(i);
            }
        }

        // if the size of the list is not 2, then there is no point of swapping
        // because there needs to be exactly two different indices
        if(indices.size() != 2) {
            return false;
        }

        String newS = swap(indices.get(0), indices.get(1), s);
        return newS.equals(goal);
    }

    private String swap(int i1, int i2, String s) {
        StringBuilder sb = new StringBuilder(s);

        char temp = sb.charAt(i1);
        sb.setCharAt(i1, sb.charAt(i2));
        sb.setCharAt(i2, temp);

        return sb.toString();
    }
}