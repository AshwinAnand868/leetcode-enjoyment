class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int j = 2; j <= n; ++j) {

            int i = 0;

            StringBuilder sb = new StringBuilder();

            while (i < result.length()) {
                int count = 0;
                char current = result.charAt(i);

                while (i < result.length() && current == result.charAt(i)) {
                    count++;
                    i++;
                }

                sb.append(count);
                sb.append(current);
            }

            result = sb.toString();

        }

        return result;

        // if(n == 1) {
        // return "1";
        // }

        // // get the previous strings
        // String str = countAndSay(n - 1);

        // // process the str
        // int i = 0;

        // StringBuilder sb = new StringBuilder();

        // while(i < str.length()) {
        // int count = 0;
        // char current = str.charAt(i);

        // while(i < str.length() && current == str.charAt(i)) {
        // count++;
        // i++;
        // }

        // sb.append(count);
        // sb.append(current);
        // }

        // return sb.toString();

    }
}