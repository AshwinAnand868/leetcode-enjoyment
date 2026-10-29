class NumArray {
    int[] seg;
    int[] nums;

    public NumArray(int[] nums) {
        int n = nums.length;

        this.nums = new int[n];
        for (int i = 0; i < n; ++i) {
            this.nums[i] = nums[i];
        }

        seg = new int[4 * n];

        if (n > 0) {
            build(0, 0, n - 1);
        }
    }

    public void update(int index, int val) {
        nums[index] = val;
        update(0, 0, nums.length - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, nums.length - 1, left, right);
    }

    void build(int ind, int low, int high) {
        if (low == high) {
            seg[ind] = nums[low];
            return;
        }

        int mid = (low + high) / 2;

        build(2 * ind + 1, low, mid);
        build(2 * ind + 2, mid + 1, high);

        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }

    int query(int ind, int low, int high, int l, int r) {
        // Completely overlaps
        if (low >= l && high <= r) {
            return seg[ind];
        }

        // Completely does not overlap
        if (low > r || high < l) {
            return 0;
        }

        // Partially overlaps
        int mid = (low + high) / 2;

        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);

        return left + right;
    }

    void update(int ind, int low, int high, int pos, int val) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) / 2;

        if (pos <= mid) {
            update(2 * ind + 1, low, mid, pos, val);
        } else {
            update(2 * ind + 2, mid + 1, high, pos, val);
        }

        // Backtrack and update parent sums
        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
    }
}
