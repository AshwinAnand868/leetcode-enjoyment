class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int runningI = 0; 

        while(runningI < chars.length) {
            int count = 0;
            char currentChar = chars[runningI];

            while (runningI < chars.length && currentChar == chars[runningI]) {
                count++;
                runningI++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                String strCount = Integer.toString(count);

                for (int i = 0; i < strCount.length(); ++i) {
                    chars[index++] = strCount.charAt(i);
                }
            }
        }

        return index;
    }
}