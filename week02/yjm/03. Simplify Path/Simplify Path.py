import re
class Solution:
    def simplifyPath(self, path: str) -> str:
        pattern = re.compile(r'\/+')
        newstring = pattern.sub(r"/", path)

        list_str = newstring.split('/')
        stack = []

        for x in list_str :
            if x == '' or x == '.' :
                continue
            if x == '..' and len(stack) < 1 :
                continue
            if x == '..' and len(stack) > 0 :
                stack.pop()
                continue
            stack.append(x)

        return '/' + '/'.join(stack)