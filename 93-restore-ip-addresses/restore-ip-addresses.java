class Solution {

    private void solve(List<String> result, int index, int n, String s, int parts, String curr) {
        if(index == n && parts == 4) {
            curr = curr.substring(0, curr.length() - 1);
            result.add(curr);
            return;
        }

        if(index + 1 <= n) {
            solve(result, index + 1, n, s, parts + 1, curr + s.substring(index, index + 1) + ".");
        }

        if(index + 2 <= n && isValid(s.substring(index, index + 2))) {
            solve(result, index + 2, n, s, parts + 1, curr + s.substring(index, index + 2) + ".");
        }

        if(index + 3 <= n && isValid(s.substring(index, index + 3))) {
            solve(result, index + 3, n, s, parts + 1, curr + s.substring(index, index + 3) + ".");
        }

    }

    public boolean isValid(String toTest) {
        if(toTest.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(toTest);

        return value >= 0 && value <= 255;
    }

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) {
            return new ArrayList<>();
        }

        int parts = 0;
        String curr = "";
        List<String> result = new ArrayList<>();

        solve(result, 0, s.length(), s, parts, curr);
        return result;
    }
}