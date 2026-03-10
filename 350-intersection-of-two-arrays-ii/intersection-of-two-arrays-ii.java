class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> valToFreqMapNums1 = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int val : nums1) {
            valToFreqMapNums1.merge(val, 1, Integer::sum);
        }


        for(int val : nums2) {
            if(valToFreqMapNums1.containsKey(val) && valToFreqMapNums1.get(val) > 0) {
                result.add(val);
                valToFreqMapNums1.merge(val, -1, Integer::sum);
            }
        }

        return result.stream().mapToInt(val -> val).toArray();


    //     List<Integer> resultList = new ArrayList<>();

    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);

    //     int i = 0, j = 0;

    //     while(i < nums1.length && j < nums2.length) {
    //         if(nums1[i] < nums2[j]) {
    //             i++;
    //         } else if(nums1[i] > nums2[j]) {
    //             j++;
    //         } else {
    //             resultList.add(nums1[i]);
    //             ++i;
    //             ++j;
    //         }
    //     }

    //     return resultList.stream().mapToInt(val -> val).toArray();
    }
}