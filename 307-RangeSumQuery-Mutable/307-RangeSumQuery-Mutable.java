// Last updated: 10/29/2026, 12:34:41 PM
1class NumArray {
2    int[] seg;
3    int[] nums;
4
5    public NumArray(int[] nums) {
6        int n = nums.length;
7
8        this.nums = new int[n];
9        for (int i = 0; i < n; ++i) {
10            this.nums[i] = nums[i];
11        }
12
13        seg = new int[4 * n];
14
15        if (n > 0) {
16            build(0, 0, n - 1);
17        }
18    }
19
20    public void update(int index, int val) {
21        nums[index] = val;
22        update(0, 0, nums.length - 1, index, val);
23    }
24
25    public int sumRange(int left, int right) {
26        return query(0, 0, nums.length - 1, left, right);
27    }
28
29    void build(int ind, int low, int high) {
30        if (low == high) {
31            seg[ind] = nums[low];
32            return;
33        }
34
35        int mid = (low + high) / 2;
36
37        build(2 * ind + 1, low, mid);
38        build(2 * ind + 2, mid + 1, high);
39
40        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
41    }
42
43    int query(int ind, int low, int high, int l, int r) {
44        // Completely overlaps
45        if (low >= l && high <= r) {
46            return seg[ind];
47        }
48
49        // Completely does not overlap
50        if (low > r || high < l) {
51            return 0;
52        }
53
54        // Partially overlaps
55        int mid = (low + high) / 2;
56
57        int left = query(2 * ind + 1, low, mid, l, r);
58        int right = query(2 * ind + 2, mid + 1, high, l, r);
59
60        return left + right;
61    }
62
63    void update(int ind, int low, int high, int pos, int val) {
64        if (low == high) {
65            seg[ind] = val;
66            return;
67        }
68
69        int mid = (low + high) / 2;
70
71        if (pos <= mid) {
72            update(2 * ind + 1, low, mid, pos, val);
73        } else {
74            update(2 * ind + 2, mid + 1, high, pos, val);
75        }
76
77        // Backtrack and update parent sums
78        seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
79    }
80}
81