class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        // shortest = BFS
        Queue<String> queue = new LinkedList<>();
        // to keep track of visited words/nodes
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1; // inclusive begin word

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; ++i) {
                String curr = queue.poll();
                char[] currArray = curr.toCharArray();

                for(int j = 0; j < currArray.length; ++j) {
                    char originalChar = currArray[j];

                    for(char ch = 'a'; ch <= 'z'; ++ch) {
                        currArray[j] = ch;
                        String next = new String(currArray);
                        if(next.equals(endWord)) return steps + 1; // inclusive end word
                        if(wordSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }

                    currArray[j] = originalChar; // restoring the original character
                }
            }

            steps++;
        
        }

        return 0;
    }
}