class Solution:
    def reverse(self, x: int) -> int:
        
        x_str = str(x)
        x_str = x_str[::-1]
        if '-' in x_str:
            x_str = x_str[-1] + x_str[:-1]
        
        ret_val = int(x_str)
        if (ret_val < -2**31) | (ret_val > 2**31-1):
            return 0

        return ret_val