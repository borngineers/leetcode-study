# Time Limit Exceeded

class Solution:
    def maxJumps(self, arr: List[int], d: int) -> int:
        arr_len = len(arr)
        max_jumping_count = 1

        def get_possible_to_go_index_list(arr_list, idx, d) :
            ret_list = []
            for sub_idx in range(idx - d, idx + d + 1) :
                check_flag = True
                if sub_idx < 0 or sub_idx > (arr_len - 1) or sub_idx == idx :
                    continue
                if arr_list[sub_idx] < arr_list[idx] :

                    start_idx = 0
                    end_idx = 0
                    if sub_idx < idx :
                        start_idx = sub_idx + 1
                        end_idx = idx
                    else :
                        start_idx = idx + 1
                        end_idx = sub_idx

                    for check_idx in range(start_idx, end_idx) :
                        if arr_list[check_idx] > arr_list[sub_idx] :
                            check_flag = False
                            break
                    if check_flag :
                        ret_list.append((sub_idx, arr_list[sub_idx]))

            if len(ret_list) > 0 :
                ret_list = sorted(ret_list, key=lambda tup: tup[1], reverse=True)
                return [x[0] for x in ret_list]
            else :
                return []

        jump_stack = []

        for idx, num in enumerate(arr) :
            temp_jumping_count = 1
            possible_idx = -1
            
            possible_idx_list = get_possible_to_go_index_list(arr, idx, d)

            if len(possible_idx_list) < 1 :
                continue

            temp_jumping_count += 1
            for x in possible_idx_list :
                jump_stack.append((x, temp_jumping_count))

            while len(jump_stack) > 0 :
                next_item = jump_stack.pop()
                next_idx = next_item[0]
                current_jump_count = next_item[1]

                if max_jumping_count < current_jump_count :
                    max_jumping_count = current_jump_count
                    
                possible_idx_list = get_possible_to_go_index_list(arr, next_idx, d)

                if len(possible_idx_list) < 1 :
                    continue

                current_jump_count += 1
                for x in possible_idx_list :
                    jump_stack.append((x, current_jump_count))

        return max_jumping_count
