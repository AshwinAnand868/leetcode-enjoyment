class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < quiet.length; ++i) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < richer.length; ++i) {
            int rich = richer[i][0];
            int poor = richer[i][1];

            adj.get(poor).add(rich);
        }

        int[] answer = new int[quiet.length];

        Arrays.fill(answer, -1);

        for (int i = 0; i < quiet.length; ++i) {
            dfs(i, adj, answer, quiet);
        }

        return answer;
    }

    public int dfs(int node, List<List<Integer>> adj, int[] answer, int[] quiet) {
        // memo logic applied
        if(answer[node] != -1) {
            return answer[node];
        }

        int minPerson = node;

        for(int neigh : adj.get(node)) {
            int potential = dfs(neigh, adj, answer, quiet);
            if (quiet[potential] < quiet[minPerson]) {
                minPerson = potential;
            }
        }

        // after exploring all the neighbours, we get the minimum for current node
        answer[node] = minPerson;

        return minPerson;
    }
}