class Solution:
    def romanToInt(self, s: str) -> int:
        roman = {
            'I':1,
            'V':5,
            'X':10,
            'L':50,
            'C':100,
            'D':500,
            'M':1000
        }

        cnt = 1
        fin = len(s)
        ret_num = 0
        if fin > 1:
            while cnt < fin:
                if roman[s[cnt-1]] >= roman[s[cnt]]:
                    ret_num += roman[s[cnt-1]]
                else:
                    ret_num -= roman[s[cnt-1]]
                cnt+=1
            ret_num += roman[s[cnt-1]]
            return ret_num
        else:
            return roman[s[0]]
