class Pair {
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color)
            return image; // avoid infinite loop if color is the same

        Queue<Pair> queue = new LinkedList<>();
        image[sr][sc] = color;
        queue.offer(new Pair(sr, sc));

        int m = image.length;
        int n = image[0].length;

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Pair pair = queue.poll();

                for (int d = 0; d < 4; ++d) {
                    int ni = pair.i + dx[d];
                    int nj = pair.j + dy[d];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && image[ni][nj] == originalColor) {
                        image[ni][nj] = color;
                        queue.offer(new Pair(ni, nj));
                    }
                }
            }
        }

        return image;
    }
}