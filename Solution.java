import java.util.*;

public class Solution
{
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode();
		TreeNode left = new TreeNode();
		TreeNode right = new TreeNode();
		TreeNode left2 = new TreeNode();
		TreeNode right2 = new TreeNode();
		left.val = 1;
		
		right.val = 10;
		root.val = 6;
		
		left2.val = 4;
		
		right2.val = 7;
		left.right = left2;
		right.left = right2;
		
		root.left = left;
		root.right = right;

		TreeNode x = new TreeNode();
		x.val = 3;
		left2.left = x;

		TreeNode y = new TreeNode();
		y.val = 5;
		left2.right = y;
		
		postOrderTraversal(root);

		System.out.println("");

		//InOrder(root);
		// PreOrder(root);
		//PostOrder(root);
		//System.out.println(list);
	}
	
	//Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void InOrder(TreeNode root) {
		if(root != null)
		{
			InOrder(root.left);
			System.out.println(root.val);
			InOrder(root.right);
		}
	}

	public static void PreOrder(TreeNode root) {
		if(root != null)
		{
			System.out.println(root.val);
			PreOrder(root.left);			
			PreOrder(root.right);
		}
	}

	public static void PostOrder(TreeNode root) {
		if(root != null)
		{
			PostOrder(root.left);			
			PostOrder(root.right);			
			System.out.println(root.val);
		}
	}

	public static void inorderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.empty())
		{
			// push all left node to the stack
			// all the way from the root
			while(root != null)
			{
				System.out.println("push " + root.val);
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			System.out.println("pop" + root.val);
			root = root.right;			
		}			
	}

	public static void preOrderTraversal(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(root != null || !stack.empty())
		{
			// push all left node to the stack
			// all the way from the root
			while(root != null)
			{
				System.out.println("push " + root.val);
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();			
			root = root.right;			
		}			
	}

	/*
			    		6
			1					10
					4		7
				3		5
	*/

	public static void postOrderTraversal(TreeNode root) 
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while(!stack.empty())
		{
			root = stack.pop();

			if(root.left == null && root.right == null)
			{				
				System.out.println(root.val);
			}			
			else
			{
				stack.push(root);

				// push right node to stack first 
				if(root.right != null)
				{
					stack.push(root.right);
					root.right = null;
				}	

				if(root.left != null)
				{
					stack.push(root.left);
					root.left = null;
				}								
			}	
		}		
	}

	public static void postOrderTraversal2(TreeNode root) 
	{
		
	}
}


