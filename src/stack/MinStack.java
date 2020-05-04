/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2

Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

package stack;

import java.util.ArrayList;
import java.util.Arrays;

public class MinStack
{
    private ArrayList<Integer> minstack;
    private ArrayList<Integer> min_item;
    private int index;
    private int min;

    public MinStack()
    {
        minstack = new ArrayList<>();
        min_item = new ArrayList<>();
        index = -1;
        min = Integer.MAX_VALUE;
    }

    public void push(int x)
    {
        if(index >= 0)
            min = min_item.get(index);
        index++;
        minstack.add(index, x);
        min_item.add(index, Math.min(min, x));
    }

    public void pop()
    {
        if(index >= 0)
        {
            minstack.remove(index);
            min_item.remove(index);
            index--;

            if(index >= 0)
                min = min_item.get(index);
            else
                min = Integer.MAX_VALUE;
        }
    }

    public int top()
    {
        if(index >= 0)
            return minstack.get(index);
        else
            return Integer.MIN_VALUE;
    }

    public int getMin()
    {
        return min_item.get(index);
    }
}
