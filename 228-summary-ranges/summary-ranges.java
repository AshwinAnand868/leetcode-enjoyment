class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int start = nums[i];

            while(i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if(start != nums[i]) {
                ranges.add("" + start + "->" + nums[i]);
            } else {
                ranges.add("" + start);
            }
        }

        return ranges;

        // if(nums.length == 0) return new ArrayList<>();

        // if (nums.length == 1) {
        //     List<String> one = new ArrayList<>();
        //     one.add(nums[0] + "");
        //     return one;
        // }

        // List<String> ranges = new ArrayList<>();

        // int start = nums[0];
        // int end = start;

        // for (int i = 0; i < nums.length - 1; ++i) {
        //     if (nums[i] + 1 == nums[i + 1]) {
        //         end = nums[i + 1];
        //     } else {
        //         String temp = "";

        //         if (start >= end) {
        //             temp = "" + start;
        //         } else {
        //             temp = start + "->" + end;
        //         }

        //         ranges.add(temp);
        //         start = nums[i + 1];
        //     }
        // }

        // if (start == nums[nums.length - 1]) {
        //     ranges.add("" + start);
        // } else {
        //     ranges.add(start + "->" + end);
        // }

        // return ranges;
    }
}