// Last updated: 9/14/2026, 4:10:17 PM
1import java.util.*;
2
3class Solution {
4
5    // left shift multiply by 2
6    // right shift divide by 2
7
8    // if (mask & (1<<i)) - if ith bit is set or not
9    // set the ith bit - use OR instead of & above
10
11    /*
12        3 steps of memo
13        size of dp array - 2 ^ n
14        all those branches goes up to 2 raise to power n
15        initialize with -1
16        2.d step before returning store the result
17        check overlapping subproblems
18    */
19
20    public boolean solve(int[] nums, int k, int bucketNo,
21                         int bucketSum, int reqSum, int mask, int[] dp) {
22
23        if(bucketNo == k) {
24            return true;
25        }
26
27        if(bucketSum == reqSum) {
28            return solve(nums, k, bucketNo + 1, 0, reqSum, mask, dp);
29        }
30
31        if(dp[mask] != -1) {
32            return dp[mask] == 1;
33        }
34
35        for(int i = 0; i < nums.length; ++i) {
36
37            if(bucketSum + nums[i] > reqSum) {
38                continue;
39            }
40
41            // if that value is already used
42            if((mask & (1 << i)) != 0) {
43                continue;
44            }
45
46            int newMask = mask | (1 << i);
47
48            if(solve(nums, k, bucketNo, bucketSum + nums[i],
49                     reqSum, newMask, dp)) {
50
51                dp[mask] = 1;
52                return true;
53            }
54        }
55
56        dp[mask] = 0;
57        return false;
58    }
59
60    public boolean canPartitionKSubsets(int[] nums, int k) {
61
62        int sum = 0;
63
64        for(int num : nums) {
65            sum += num;
66        }
67
68        if(sum % k != 0) {
69            return false;
70        }
71
72        int reqSum = sum / k;
73
74        int[] dp = new int[1 << nums.length];
75        Arrays.fill(dp, -1);
76
77        return solve(nums, k, 0, 0, reqSum, 0, dp);
78    }
79}