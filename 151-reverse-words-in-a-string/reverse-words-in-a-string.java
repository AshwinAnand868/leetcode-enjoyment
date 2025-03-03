class Solution {
    public String reverseWords(String s) {

        s = s.trim(); // trim the spaces

        String[] words = s.split("\\s+");
        int n = words.length;

        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<String>();

        for(int i = 0; i < n; ++i) {
            st.push(words[i]);
            // sb.append(words[i]);

            // if(i > 0) {
            //     sb.append(" ");
            // }
        }

        while(st.size() != 1) {
            sb.append(st.pop());
            sb.append(" ");
        }

        sb.append(st.pop());

        return sb.toString();
    }
}