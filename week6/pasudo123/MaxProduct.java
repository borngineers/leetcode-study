package week06;

import java.math.BigInteger;

public class MaxProduct {

    public static void main(String[]args) {

        // 1,null,2,3,4,null,null,5,6

        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(6);

//        final TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(9);
//
//        root.left.left = new TreeNode(10);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(8);
//        root.right.right = new TreeNode(6);
//
//        root.left.left.left = new TreeNode(5);
//        root.left.left.right = new TreeNode(4);
//        root.left.right.left = new TreeNode(11);
//        root.left.right.right = new TreeNode(1);

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

    static final String MOD = "1000000007";
    static BigInteger maxValue = BigInteger.ZERO;
    static BigInteger total = BigInteger.ZERO;

    public static int maxProduct(TreeNode root) {

        circuit(root);
        calculate(root);

        System.out.println(total);

        return maxValue.mod(new BigInteger(MOD)).intValue();
    }

    static void circuit(TreeNode node){

        if(node == null) {
            return;
        }

        total = total.add(BigInteger.valueOf(node.val));
        circuit(node.left);
        circuit(node.right);
    }

    private static BigInteger calculate(TreeNode node) {

        if(node == null) {
            return BigInteger.ZERO;
        }

        BigInteger leftTotal = calculate(node.left);
        BigInteger rightTotal = calculate(node.right);

        BigInteger value = BigInteger.valueOf(node.val);
        BigInteger subTotal = value.add(leftTotal).add(rightTotal);

        BigInteger subTotalValue = total.subtract(subTotal);
        subTotalValue = subTotalValue.multiply(subTotal);

        maxValue = (maxValue.compareTo(subTotalValue) < 0) ? subTotalValue : maxValue;

        return subTotal;
    }
}
