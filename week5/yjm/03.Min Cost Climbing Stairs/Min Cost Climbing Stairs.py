class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:

        first_step = second_step = 0
        
        for step_cost in reversed(cost) :
            first_step, second_step = step_cost + min(first_step, second_step), first_step
            
        return min(first_step, second_step)
