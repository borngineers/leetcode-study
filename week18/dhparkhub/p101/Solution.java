package p101;

class TreeNode {
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

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        List<Integer> lList = preorder(root.left);
//        List<Integer> rList = postorder(root.right);
//        return lList.equals(rList);
//    }
//
//    private List<Integer> preorder(TreeNode node) {
//        List<Integer> list = new ArrayList<>();
//        if (node == null) {
//            return list;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(node);
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.pop();
//            if (temp == null) {
//                list.add(null);
//                continue;
//            }
//            list.add(temp.val);
//            stack.push(temp.left);
//            stack.push(temp.right);
//        }
//        return list;
//    }
//
//    private List<Integer> postorder(TreeNode node) {
//        List<Integer> list = new ArrayList<>();
//        if (node == null) {
//            return list;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(node);
//        while (!stack.isEmpty()) {
//            TreeNode temp = stack.pop();
//            if (temp == null) {
//                list.add(null);
//                continue;
//            }
//            list.add(temp.val);
//            stack.push(temp.right);
//            stack.push(temp.left);
//        }
//        return list;
//    }
//}