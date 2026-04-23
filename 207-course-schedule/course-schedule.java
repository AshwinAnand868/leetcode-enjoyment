class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        List<List<Integer>> adjList = new ArrayList<>();

        // int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; ++i) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < p.length; ++i) {
            int a = p[i][0];
            int b = p[i][1];

            adjList.get(a).add(b);
            // indegree[b]++;
        }

       boolean[] visited = new boolean[numCourses];
       boolean[] pathVisited = new boolean[numCourses];

       for(int i = 0; i < numCourses; ++i) {
            if(!visited[i]) {
                if(dfs(i, adjList, visited, pathVisited)) {
                    return false;
                }
            }
       }

        return true;
    }

    private boolean dfs(int u, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisited) {
        visited[u] = true;
        pathVisited[u] = true;

        for(int v : adjList.get(u)) {
            if(!visited[v]) {
                if(dfs(v, adjList, visited, pathVisited)) {
                    return true;
                }
            } else if(pathVisited[v]) {
                return true;
            }
        }

        pathVisited[u] = false; // backtrack
        return false;
    }

    // private boolean topology(List<List<Integer>> adjList, int numCourses, int[] indegree) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     int count = 0;

    //     for(int i = 0; i < numCourses; ++i) {
    //         if(indegree[i] == 0) {
    //             queue.offer(i);
    //             count++;
    //         }
    //     }

    //     while(!queue.isEmpty()) {
    //         int node = queue.poll();

    //         for(int neighbour : adjList.get(node)) {
    //             indegree[neighbour]--;

    //             if(indegree[neighbour] == 0) {
    //                 queue.offer(neighbour);
    //                 count++;
    //             }
    //         }
    //     }

    //     if(count == numCourses) {
    //         return true;
    //     }

    //     return false;
    // }
}