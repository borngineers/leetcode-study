class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # no new array
        list_len = len(nums)
        
        if list_len < 2 :
            return list_len
        
        temp_num = nums.pop(0)
        
        for x in range(list_len) :
            if len(nums) < 1 :
                nums.append(temp_num)
                break
            if temp_num > nums[0] :
                nums.append(temp_num)
                return len(nums)
            
            selected_item = nums.pop(0)
            if temp_num == selected_item :
                continue
            nums.append(temp_num)
            temp_num = selected_item
        return len(nums)
        
