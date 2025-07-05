class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colorGraph = new int[n];
        
        Arrays.fill(colorGraph, -1);
        
        int color1 = 0;
        int color2 = 1;
        
        for(int start = 0; start < n; ++start) {
            if(colorGraph[start] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(start);
                colorGraph[start] = 0;
                
                while(!queue.isEmpty()) {
                    int node = queue.poll();
                    int color = colorGraph[node];
                    
                    for(int neighbour : graph[node]) {
                        if(colorGraph[neighbour] == -1) {
                            if(color == 0) {
                                colorGraph[neighbour] = 1;
                            } else {
                                colorGraph[neighbour] = 0;
                            }
                            queue.offer(neighbour);
                        } else if (colorGraph[neighbour] == color) {
                            return false;   
                        }
                    }
                }
                
            }
        }
        
        return true;
    }
}