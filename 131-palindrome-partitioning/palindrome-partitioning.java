class Solution {

    public void backtrack(List<String> temp, List<List<String>> result, int index, String s) {
        if(s.length() == index) {
            List<String> partitions = new ArrayList<>(temp);
            result.add(partitions);
            return;
        }

        // check every possible substring from that index
        for(int i = index; i < s.length(); ++i) {
            if(isPartition(index, i, s)) {
                temp.add(s.substring(index, i + 1));
                backtrack(temp, result, i + 1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPartition(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(new ArrayList<>(), result, 0, s);
        return result;
    }
}