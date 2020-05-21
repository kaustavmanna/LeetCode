/*
Given a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Constraints:
The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
*/

package tree;

import standard.TreeNode;

public class DeepestLeavesSum
{
    private static int sum;

    public static void main(String[] args)
    {

    }

    public static int deepestLeavesSum(TreeNode root)
    {
        sum = 0;
        int maxdepth = maxDepth(root);
        deepestLeavesSum(root, 1, maxdepth);
        return sum;
    }

    private static int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    private static void deepestLeavesSum(TreeNode root, int depth, int maxdepth)
    {
        if(root == null)
            return;
        if(depth == maxdepth)
            sum += root.val;
        deepestLeavesSum(root.right, depth + 1, maxdepth);
        deepestLeavesSum(root.left, depth + 1, maxdepth);
    }
}
