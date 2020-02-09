# Runtime: 108 ms, faster than 92.02% of Python3 online submissions for The K Weakest Rows in a Matrix.
# Memory Usage: 12.9 MB

class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        
        soldier_amount_list = []
        
        for row_idx, row_list in enumerate(mat) :
            soldier_count = 0
            for item in row_list :
                if item == 0 :
                    break
                else :
                    soldier_count += 1
            soldier_amount_list.append((row_idx, soldier_count))
                  
        # soldier_amount_list = [(0, 1), (1, 4), (2, 1), (3, 1)]
        # sorted_list = [(1, 4), (0, 1), (2, 1), (3, 1)]
        sorted_list = sorted(soldier_amount_list, key=lambda tup: tup[1])
        
        # select only row index in weakest top k
        ret_list = [weakest_item[0] for weakest_item in sorted_list[:k]]
        
        return ret_list
                    
