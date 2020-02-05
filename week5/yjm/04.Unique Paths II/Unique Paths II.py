# Runtime: 44 ms
# Memory Usage: 12.8 MB

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        
        
        col_len = len(obstacleGrid)
        if col_len == 0 :
            return 0
        
        if obstacleGrid[0][0] == 1 :
            return 0
        
        row_len = len(obstacleGrid[0])
        
        for col_idx, row_list in enumerate(obstacleGrid) :
            first_col_flag = False
            if col_idx == 0 :
                for row_idx, row_item in enumerate(row_list) :
                    
                    if first_col_flag :
                        obstacleGrid[col_idx][row_idx] = 0
                        continue
                    if row_item == 0 :
                        obstacleGrid[col_idx][row_idx] = 1
                    else :
                        obstacleGrid[col_idx][row_idx] = 0
                        first_col_flag = True
            else :
                for row_idx, row_item in enumerate(row_list) :
                    if row_item == 1 :
                        obstacleGrid[col_idx][row_idx] = 0
                        
                    else :
                        if row_idx == 0 and obstacleGrid[col_idx-1][row_idx] == 0 :
                            obstacleGrid[col_idx][row_idx] = 0
                        elif row_idx == 0 :
                            obstacleGrid[col_idx][row_idx] = 1
                        else :
                            obstacleGrid[col_idx][row_idx] = obstacleGrid[col_idx-1][row_idx] + obstacleGrid[col_idx][row_idx-1]
        
        return obstacleGrid[col_len-1][row_len-1]
