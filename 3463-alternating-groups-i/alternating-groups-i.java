class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < colors.length + 2; i++) {

            list.add(colors[i % colors.length]);

            if (i > 2) {
                list.remove(0);
            }

            if (list.size() == 3 && list.get(1) != list.get(0)
                    && list.get(1) != list.get(2)) {
                count++;
            }

        }

        return count;
    }
}