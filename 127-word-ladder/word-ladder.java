class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                String curr = queue.poll();
                char[] arr = curr.toCharArray();

                for (int j = 0; j < arr.length; ++j) {
                    char original = arr[j];

                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (ch == original) continue;

                        arr[j] = ch;
                        String newWord = new String(arr);

                        if (newWord.equals(endWord)) {
                            return steps + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // mark visited
                        }
                    }

                    arr[j] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}