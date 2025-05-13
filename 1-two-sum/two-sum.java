class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> n=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int a=target-num;
            if(n.containsKey(a)){
                return new int[] {n.get(a),i};
            }
            n.put(num,i);
        }
        return new int[] {};
    }
}
