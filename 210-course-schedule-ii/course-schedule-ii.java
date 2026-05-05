class Solution {
    public int[] findOrder(int n, int[][] prereqs) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; ++i) {
            adjList.add(new ArrayList<>());
        }

        // build from edges/prereqs
        for(int i = 0; i < prereqs.length; ++i) {
            int a = prereqs[i][0];
            int b = prereqs[i][1];
            
            adjList.get(b).add(a);
        }


        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; ++i) {
            if(!visited[i] && dfs(i, adjList, visited, pathVisited, stack)) {
                return new int[]{};
            }
        }

        int i = 0;
        while(!stack.isEmpty()) {
            result[i] = stack.pop();
            i++;
        }

        return result;
    }

    private boolean dfs(int node, List<List<Integer>> adjList,
                        boolean[] visited, boolean[] pathVisited, Stack<Integer> stack) {

        pathVisited[node] = true;
        visited[node] = true;

        for(int neighbour : adjList.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour, adjList, visited, pathVisited, stack)) {
                    return true; // cycle
                }
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[node] = false;
        stack.push(node); // pehle mere bacho ko then mujhe
        return false;
    }
}