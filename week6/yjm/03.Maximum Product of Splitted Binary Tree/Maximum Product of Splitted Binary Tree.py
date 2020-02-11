# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Time Limit Exceeded

class Solution:
    def maxProduct(self, root: TreeNode) -> int:
        def count_sub_tree(node) :
            node_count = 0
            node_val_sum = 0
            node_stack = [node]
            val_list_from_trees = []

            while len(node_stack) > 0 :
                current_node = node_stack.pop()
                node_val_sum += current_node.val
                val_list_from_trees.append(current_node.val)
                node_count += 1

                if current_node.left != None :
                    node_stack.append(current_node.left)
                if current_node.right != None :
                    node_stack.append(current_node.right)

            return (node_count, node_val_sum, val_list_from_trees)

        temp = count_sub_tree(root)
        all_node_count = temp[0]
        all_node_sum = temp[1]
        all_node_vals = temp[2]

        max_node_multiplication = 0

        temp_stack = [root]
        while len(temp_stack) > 0 :
            temp_vals_sum = 0
            current_node = temp_stack.pop()
            current_node_sum = count_sub_tree(current_node)[1]
            temp_vals_sum = (all_node_sum - current_node_sum) * current_node_sum

            if max_node_multiplication < temp_vals_sum :
                max_node_multiplication = temp_vals_sum

            if current_node.left != None :
                temp_stack.append(current_node.left)
            if current_node.right != None :
                temp_stack.append(current_node.right)

        if max_node_multiplication > 10**10 :
            max_node_multiplication = max_node_multiplication % (10**9+7)
        return max_node_multiplication
