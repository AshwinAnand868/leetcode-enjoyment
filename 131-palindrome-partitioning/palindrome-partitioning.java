class Solution {

    public void backtrack(List<List<String>> result, List<String> path, int index, String s) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); ++i) {
            if (isPalindrome(index, i, s)) {
                path.add(s.substring(index, i + 1)); // Fix is here
                backtrack(result, path, i + 1, s);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }
}
