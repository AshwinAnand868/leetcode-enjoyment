class Pair2 {
    int value;
    int index;

    Pair2(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
         // MIN heap
        PriorityQueue<Pair2> pq = new PriorityQueue<>((a, b) -> {
            if (a.value != b.value) {
                return a.value - b.value;
            } else {
                return a.index - b.index;
            }
        });

        for (int i = 0; i < nums.length; ++i) {
            pq.offer(new Pair2(nums[i], i));
        }

        while (k > 0) {

            Pair2 pair = pq.peek(); // pair with minimum value in the queue
            pq.poll();

            int value = pair.value * multiplier;
            pq.offer(new Pair2(value, pair.index));

            k--;
        }

        for (Pair2 p : pq) {
            nums[p.index] = p.value;
        }

        return nums;
    }
}