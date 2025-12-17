class SummaryRanges {
    private Set<Integer> values;
    public SummaryRanges() {
        values = new HashSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {
        if(values.isEmpty()) {
            return new int[0][0];
        }

        List<Integer> list = new ArrayList<>(values);
        Collections.sort(list);

        List<int[]> result = new ArrayList<>();

        int start = list.get(0);
        int end = start;

        for(int i = 1; i < list.size(); ++i) {
            int curr = list.get(i);

            if(curr == end + 1) {
                end = curr; // extend the interval
            } else {
                result.add(new int[] {start, end});
                start = curr;
                end = curr;
            }
        }

        result.add(new int[] {start, end}); // merging last interval

        return result.toArray(new int[result.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */