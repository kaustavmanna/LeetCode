/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
return its bottom-up level order traversal as
[
    [15,7],
    [9,20],
    [3]
]
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal
{
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        return null;
    }
}
