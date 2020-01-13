class Solution:
    def isValid(self, s: str) -> bool:
        fo = '('
        fe = ')'
        so = '['
        se = ']'
        to = '{'
        te = '}'

        stack = []

        if len(s) % 2 != 0 :
            return False

        for x in s :
            if x == fo or x == so or x == to :
                stack.append(x)
                continue
            if x == fe or x == se or x == te :
                if len(stack) < 1 :
                    return False
                check_val = stack.pop()
                if check_val == fo and x == fe :
                    continue
                elif check_val == so and x == se :
                    continue
                elif check_val == to and x == te :
                    continue
                else :
                    return False
                
        if len(stack) == 0 :
            return True
        
        return False