/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:
Input:    1         1
         / \       / \
        2   3     2   3

       [1,2,3],   [1,2,3]

Output: true

Example 2:
Input    1         1
        /           \
        2             2

       [1,2],     [1,null,2]

Output: false

Example 3:

Input:   1         1
        / \       / \
       2   1     1   2

      [1,2,1],   [1,1,2]

Output: false
 */

import com.sun.source.tree.Tree;

public class SameTree
{
    public static void main(String[] args)
    {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null & q == null)
            return true;
        else if((p == null && q != null) || (p != null && q == null))
            return false;
        else if(p.val != q.val)
            return false;
        else
            return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
