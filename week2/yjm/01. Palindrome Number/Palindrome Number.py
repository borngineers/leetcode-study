class Solution:
    def isPalindrome(self, x: int) -> bool:
        return False if x < 0 else True if list(str(x)) == list(str(x))[::-1] else False