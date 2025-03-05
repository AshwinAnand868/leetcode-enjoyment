class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        // get the previous strings
        String str = countAndSay(n - 1);

        // process the str
        int i = 0;

        StringBuilder sb = new StringBuilder();

        while(i < str.length()) {
            int count = 0;
            char current = str.charAt(i);

            while(i < str.length() && current == str.charAt(i)) {
                count++;
                i++;
            }

            sb.append(count);
            sb.append(current);
        }

        return sb.toString();

    }
}