class Solution {
    private String rle(String curr) {
        int count = 1;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < curr.length() - 1; i++) {
            if (curr.charAt(i) == curr.charAt(i + 1)) {
                count++;
            } else {
                str.append(count);
                str.append(curr.charAt(i));
                count = 1;
            }
        }

        str.append(count);
        str.append(curr.charAt(curr.length() - 1));
        
        return str.toString();
    }

    private String countAndSayRecursive(int num, int n, String curr) {
        if (num == n)
            return curr;
        curr =  rle(curr);
        return countAndSayRecursive(num + 1, n,curr);

    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String str = countAndSayRecursive(1, n, "1");
        return str;
    }
}