package tree;/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
         /  \
        15   7
return its depth = 3.
*/

import standard.TreeNode;

public class MaximumDepthOfBinaryTree
{
    public static void main(String[] args)
    {
        /*Defining the Tree*/
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        else
            return (Math.max(maxDepth(root.left), maxDepth(root.right)) + 1);
    }
}
