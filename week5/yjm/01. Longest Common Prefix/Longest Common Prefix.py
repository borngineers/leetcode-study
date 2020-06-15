
// Runtime: 32 ms
// Memory Usage: 12.8 MB

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs_len = len(strs)
        
        if strs_len == 0 :
            return ""
        if strs_len == 1 :
            return strs[0]
        
        shortest_word_idx = 0
        shortest_word_len = None
        
        same_prefix = ""
                
        for idx, word in enumerate(strs) :
            temp_len = len(word)
            if shortest_word_len is None :
                shortest_word_len = temp_len
                continue
            if shortest_word_len > temp_len :
                shortest_word_len = temp_len
                shortest_word_idx = idx
                
        for char_idx in range(shortest_word_len) :
            checking_char = strs[0][char_idx]
            if all(checking_char == x[char_idx] for x in strs[1:]) :
                same_prefix += checking_char
            else :
                break
                
        return same_prefix
