# Runtime: 52 ms
# Memory Usage: 12.8 MB

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:

        one_step = 0
        two_step = 0
        
        for step_cost in cost :
            temp = step_cost + min(one_step, two_step)
            two_step = one_step
            one_step = temp
            
            #one_step, two_step = step_cost + min(one_step, two_step), one_step
            
        return min(one_step, two_step)
