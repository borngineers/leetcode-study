# Runtime: 56 ms
# Memory Usage: 12.8 MB

class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        # Constraints
        # i != j
        # 0 <= i, j < arr.length
        # arr[i] == 2 * arr[j]
        # 2 <= arr.length <= 500
        # -10^3 <= arr[i] <= 10^3
        
        def check_double(arr_list) :
            cache_dict = {}
            for num_m in arr_list :
                if num_m in cache_dict :
                    return True
                else :
                    if (num_m % 2) == 1 :
                        continue
                    cache_dict[(int)(num_m/2)] = 0

            return False
        
        sorted_arr = sorted(arr, reverse=True)
        
        negative_idx = len(arr)
        for idx, x in enumerate(sorted_arr) :
            if x < 0 :
                negative_idx = idx
                break
                
        positive_list = sorted_arr[:negative_idx]
        negative_list = sorted(sorted_arr[negative_idx:])
        
        flag_positive = check_double(positive_list)
        flag_negative = check_double(negative_list)
        
        return flag_positive or flag_negative
