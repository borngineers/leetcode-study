# Runtime: 240 ms
# Memory Usage: 13.3 MB

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        change_count = 0
        s_dict = {}
        
        for alphabet in s :
            if alphabet in s_dict :
                s_dict[alphabet] += 1
            else :
                s_dict[alphabet] = 1
                
        for alphabet in t :
            if alphabet in s_dict :
                if s_dict[alphabet] <= 0 :
                    change_count += 1
                else :
                    s_dict[alphabet] -= 1
            else :
                change_count += 1
        
        return change_count
