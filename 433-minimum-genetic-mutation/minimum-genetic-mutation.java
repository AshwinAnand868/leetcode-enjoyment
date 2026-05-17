class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] choices = {'A', 'C', 'G', 'T'};

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; ++k) {
                String curr = queue.poll();
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; ++i) {
                    char original = arr[i];

                    for (char ch : choices) {
                        if (ch == original) continue;

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (newWord.equals(endGene)) {
                            return steps + 1;
                        }

                        if (bankSet.contains(newWord)) {
                            queue.offer(newWord);
                            bankSet.remove(newWord);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return -1;
    }
}