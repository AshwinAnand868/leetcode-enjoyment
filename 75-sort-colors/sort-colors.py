class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        cnt0 = 0
        cnt1 = 0
        cnt2 = 0

        for i in range(len(nums)):
            if nums[i] == 0:
                cnt0 += 1
            elif nums[i] == 1:
                cnt1 += 1
            else:
                cnt2 += 1
        
        i = 0
        while i < cnt0:
            nums[i] = 0
            i += 1
        
        while i < (cnt0 + cnt1):
            nums[i] = 1
            i += 1
        
        while i < (cnt0 + cnt1 + cnt2):
            nums[i] = 2
            i += 1

        return nums



        