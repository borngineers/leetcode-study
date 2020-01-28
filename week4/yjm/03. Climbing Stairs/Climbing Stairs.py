class Solution:
    def climbStairs(self, n: int) -> int:
        
        def calcCombination(a: int, b: int) -> int :
            a_val = 1
            b_val = 1
            for x in range(0, b) :
                a_val *= a-x
                b_val *= b-x
                
            return int(a_val / b_val)
        
        if n < 4 :
            return n
        
        max_2steps = int(n/2)
        total_ways = 1 # all 1steps
        
        if n % 2 == 0 :
            total_ways = 2
            for x in range(1, max_2steps) :
                total_ways += calcCombination(n-x, x)
        else :
            for x in range(1, max_2steps+1) :
                total_ways += calcCombination(n-x, x)
        
        return total_ways
