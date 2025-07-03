import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at current level

            for (int i = 0; i < size; ++i) {
                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; ++j) {
                    char originalChar = arr[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        arr[j] = c;
                        String nextWord = new String(arr);

                        if (nextWord.equals(endWord)) return steps + 1;

                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    arr[j] = originalChar; // restore original character
                }
            }

            steps++;
        }

        return 0;
    }
}
