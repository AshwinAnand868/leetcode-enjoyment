class Solution {

    class Pair {
        char ch;
        int count;

        Pair() {}
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        if(s.length() < 3) return s;

        for(char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return b.count - a.count;
        });

        for(char ch : hm.keySet()) {
            pq.offer(new Pair(ch, hm.get(ch)));
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(String.valueOf(curr.ch).repeat(curr.count));
        }

        return sb.toString();
    }
}