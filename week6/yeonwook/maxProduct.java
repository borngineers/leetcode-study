package practice;

import practice.Solution33;
import practice.TreeNode;

public class Solution3 {
	
	public static void main(String args[]) {
		
		Solution33 c1 = new Solution33();
		
		
	}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution33 {
	
	TreeNode subNode= null;
	
    public int maxProduct(TreeNode root) {
    	
    	subNode = null;
    	
    	nodeSearch(root);
    	
    	return nodeValueSum(root) * nodeValueSum(subNode);
    }
    
    public void nodeSearch(TreeNode node) {
    	
    	if(node==null) {
    		return ;
    	}
    	
    	if(count(node.left)+1 == count(node.right)) {
    		subNode = node.right;
    		node.right = null;
    	}
    	
    	if(count(node.right)+1 == count(node.left)) {
    		subNode = node.left;
    		node.left = null;
    	}
    	
    	nodeSearch(node.left);
    	nodeSearch(node.right);
		
    }
    
    public int count(TreeNode node) {
    	
    	if(node==null) {
    		return 0;
    	}
    	
    	return count(node.left)+count(node.right)+1;
    }
    
    public int nodeValueSum(TreeNode node) {
    	if(node==null) {
    		return 0;
    	}
    	
    	return node.val + nodeValueSum(node.left) + nodeValueSum(node.right);
    }
}