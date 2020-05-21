/*
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
If there are no nodes with an even-valued grandparent, return 0.

Example 1:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Constraints:
The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
*/

package tree;

import standard.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent
{
    public static void main(String[] args)
    {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(7);

        System.out.println(sumEvenGrandparent(treeNode));
    }

    public static int sumEvenGrandparent(TreeNode root)
    {
        return sumEvenGrandparent(root, null, null);
    }

    private static int sumEvenGrandparent(TreeNode root, TreeNode parent, TreeNode grandparent)
    {
        if(root == null)
            return 0;
        int sum = 0;
        if(grandparent != null && grandparent.val % 2 == 0)
            sum += root.val;

        return sum + sumEvenGrandparent(root.left, root, parent) + sumEvenGrandparent(root.right, root, parent);
    }
}
