class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        queue.offer(0);
        visited[0] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            Integer currRoom = queue.poll();

            count++;

            for(int neighbour : rooms.get(currRoom)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return count == rooms.size();
    }
}