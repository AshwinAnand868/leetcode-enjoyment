class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; ++i) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int steps = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- > 0) {
                int curr = queue.poll();

                if(curr == n - 1) {
                    return steps;
                }

                int left = curr - 1;
                int right = curr + 1;

                if(left >= 0 && !visited[left]) {
                    visited[left] = true;
                    queue.offer(left);
                }

                if(right <  n && !visited[right]) {
                    visited[right] = true;
                    queue.offer(right);
                }

                if(map.containsKey(arr[curr])) {
                    for(int idx : map.get(arr[curr])) {
                        if(!visited[idx]) {
                            queue.offer(idx);
                            visited[idx] = true;
                        }
                    }
                }

                map.remove(arr[curr]);
            }

            steps++;
        }

        return -1;
    }
}