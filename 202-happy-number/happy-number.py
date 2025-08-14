class Solution(object):
    def isHappy(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if(num == 1 or num == 7):
            return True
        elif(num < 9):
            return False

        sum_ = 0
        while(num > 0):
            temp = num % 10
            sum_ += temp * temp
            num = num//10
        
        return self.isHappy(sum_)

        # seen = set()

        # while(n != 1 and n not in seen):
        #     seen.add(n)
        #     n = sum(int(digit) ** 2 for digit in str(n))
        # return n == 1
        