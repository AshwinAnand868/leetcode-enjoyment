class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        min_price_so_far = sys.maxint
        profit = 0

        for i in range(len(prices)):
            min_price_so_far = min(prices[i], min_price_so_far)
            profit = max(profit, prices[i] - min_price_so_far)
        
        return profit