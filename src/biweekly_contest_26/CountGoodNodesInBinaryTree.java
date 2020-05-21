/*
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.

Constraints:
The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
*/

package biweekly_contest_26;

import standard.TreeNode;

import java.util.Stack;

public class CountGoodNodesInBinaryTree
{
    public static void main(String[] args)
    {

    }

    public static int goodNodes(TreeNode root)
    {
        Stack<ModifiedTree> stack = new Stack<>();
        stack.push(new ModifiedTree(root, root.val));
        int count = 1;

        while(!stack.isEmpty())
        {
            ModifiedTree curr = stack.pop();
            if(curr.node.right != null)
            {
                int max = Math.max(curr.max, curr.node.right.val);
                if(max <= curr.node.right.val)
                    count++;
                stack.push(new ModifiedTree(curr.node.right, max));
            }

            if(curr.node.left != null)
            {
                int max = Math.max(curr.max, curr.node.left.val);
                if(max <= curr.node.left.val)
                    count++;
                stack.push(new ModifiedTree(curr.node.left, max));
            }
        }
        return count;
    }
}

class ModifiedTree
{
    TreeNode node;
    int max;

    ModifiedTree(TreeNode node, int max)
    {
        this.node = node;
        this.max = max;
    }
}
