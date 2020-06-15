class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        base_num = numbers[0]
        for i in range(0, len(numbers)-1):
            if i > 0 and numbers[i] <= base_num:
                continue
            for j in range(i+1, len(numbers)):
                if numbers[i] + numbers[j] > target:
                    break
                if numbers[i] + numbers[j] == target:
                    return [i+1, j+1]