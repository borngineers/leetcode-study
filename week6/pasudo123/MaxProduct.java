package week06;

public class MaxProduct {

    public static void main(String[]args) {

        // 1,null,2,3,4,null,null,5,6

//        final TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(6);

        final TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(5);
//        root.left.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(1);

        System.out.println(maxProduct(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static final int MOD = 1000000007;
    static int maxValue = -1;
    static long total = 0;

    public static int maxProduct(TreeNode root) {

        circuit(root);
        calculate(root);

        return maxValue;
    }

    static void circuit(TreeNode node){

        if(node == null) {
            return;
        }

        total += node.val;
        circuit(node.left);
        circuit(node.right);
    }

    private static int calculate(TreeNode node) {

        if(node == null) {
            return 0;
        }

        int leftTotal = calculate(node.left) % MOD;
        int rightTotal = calculate(node.right) % MOD;
        int subTotal = (node.val + leftTotal + rightTotal) % MOD;

        maxValue = (maxValue > (int)mod(subTotal)) ? maxValue : (int)mod(subTotal);

        return subTotal;
    }

    private static long mod(final int subTotal){


        long value = (total - (subTotal)) * subTotal;
        System.out.println((total - (subTotal)) + " * " + subTotal + " = " + value);

        return (value % MOD);
    }
}
