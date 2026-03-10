class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        int steps = 1;

        while(!queue.isEmpty()) {
            
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                String curr = queue.poll();
                char[] arr = curr.toCharArray();
                for(int k = 0; k < arr.length; ++k) {
                    char originalCh = arr[k];
                    for(char ch = 'a'; ch <= 'z'; ++ch) {
                        arr[k] = ch;
                        String temp = new String(arr);
                        if(temp.equals(endWord)) {
                            return steps + 1;
                        }

                        if(wordSet.contains(temp) && !visited.contains(temp)) {
                            visited.add(temp);
                            queue.offer(temp);
                        }
                    }

                    arr[k] = originalCh;
                }

            }
            steps++;
        }
        return 0; // if no path exists from begin word to end word
    }
}