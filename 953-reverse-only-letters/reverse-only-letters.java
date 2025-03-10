class Solution {
    public String reverseOnlyLetters(String s) {

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();

        while(left < right) {
            while(left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }

            if(left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return new String(chars);

        // if (s.length() < 2)
        //     return s;

        // StringBuilder sb = new StringBuilder();
        // HashMap<Integer, Character> map = new HashMap<>();

        // for (int i = 0; i < s.length(); ++i) {
        //     char ch = s.charAt(i);

        //     if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        //         sb.append(ch);
        //     } else {
        //         map.put(i, ch);
        //     }
        // }

        // if (map.size() == s.length())
        //     return s;

        // sb.reverse();

        // StringBuilder res = new StringBuilder();
        // int i = 0;

        // while (res.length() <= s.length()) {
        //     if (map.containsKey(res.length())) {
        //         int len = res.length();
        //         res.append(map.get(len));
        //         map.remove(len);
        //     } else {
        //         if (i >= sb.length())
        //             break;
        //         res.append(sb.charAt(i));
        //         i++;
        //     }
        // }

        // return res.toString();
    }
}