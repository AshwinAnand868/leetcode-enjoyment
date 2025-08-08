class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        valToIndex = {}
        for i in range(len(nums)):
            rem = target - nums[i]

            if rem in valToIndex:
                return [valToIndex[rem], i]
            
            valToIndex[nums[i]] = i

        return []
        