import java.util.*;

public class LeetCode101 {
    /**
     * 101. Symmetric Tree
     * https://leetcode.com/problems/symmetric-tree/submissions/
     *
     * */
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode sample = new TreeNode(1);
        sample.left = new TreeNode(2);
        sample.right = new TreeNode(2);
        sample.left.left = new TreeNode(3);
        sample.left.right = new TreeNode(4);
        sample.right.left = new TreeNode(4);
        sample.right.right = new TreeNode(3);

        boolean result = solution.isSymmetric(sample);
        System.out.println(result);
    }

    static class Solution {
        // Runtime: 3 ms, faster than 8.34% of Java online submissions for Symmetric Tree.
        // Memory Usage: 40.2 MB, less than 5.03% of Java online submissions for Symmetric Tree.
        public boolean isSymmetric(TreeNode root) {

            if (root == null) { return true; }

            Queue<TreeNode> queue = new LinkedList<>();
            ArrayList<TreeNode> list = new ArrayList<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                while (!queue.isEmpty()) {
                    TreeNode temp = queue.poll();
                    list.add(temp.left);
                    list.add(temp.right);
                }

                if (list.size() % 2 == 1) { return false; }
                int startIndex = 0;
                int endIndex = list.size() - 1;
                while (startIndex < endIndex) {
                    TreeNode firstNode = list.get(startIndex++);
                    TreeNode secondNode = list.get(endIndex--);

                    if (firstNode == null || secondNode == null) {
                        if (firstNode == null && secondNode == null) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                    if (firstNode.val != secondNode.val) {
                        return false;
                    }
                }

                for (TreeNode node : list) {
                    if (node == null) { continue; }
                    queue.add(node);
                }
                list.clear();
            }
            return true;
        }

        public int getDepthSize(int depth) {
            return (int)Math.pow(2, depth);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
