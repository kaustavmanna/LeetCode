/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
        1
       / \
      2   2
     / \ / \
    3  4 4  3

But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
      \   \
      3    3

Follow up: Solve it both recursively and iteratively.
*/

public class SymmetricTree
{
    public static void main(String[] args)
    {
        
    }

    public static boolean isSymmetric(TreeNode root)
    {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;
        else if((left == null && right != null) || (left != null && right == null))
            return false;
        else if(left.val != right.val)
            return false;
        else
            return(isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left));
    }
}
