class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        count = 0
        element = -1

        for i in range(len(nums)):
            if count == 0:
                count = 1
                element = nums[i]
            elif element == nums[i]:
                count += 1
            else:
                count -= 1

        count = 0
        for i in range(len(nums)):
            if nums[i] == element:
                count += 1

        if count > (len(nums) / 2):
            return element
        return -1



        