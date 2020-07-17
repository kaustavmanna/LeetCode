/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

package linkedlist;

import standard.ListNode;
import java.util.Stack;

public class AddTwoNumbersII
{
    public static void main(String[] args)
    {
        ListNode num1 = new ListNode(7);
        num1.next = new ListNode(2);
        num1.next.next = new ListNode(4);
        num1.next.next.next = new ListNode(3);

        ListNode num2 = new ListNode(5);
        num2.next = new ListNode(6);
        num2.next.next = new ListNode(3);

        ListNode trav = new AddTwoNumbersII().addTwoNumbers(num1, num2);
        while(trav != null)
        {
            System.out.print(trav.val + " ");
            trav = trav.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode trav = l1;
        while(trav != null)
        {
            stack1.push(trav.val);
            trav = trav.next;
        }

        trav = l2;
        while(trav != null)
        {
            stack2.push(trav.val);
            trav = trav.next;
        }

        int cf = 0;
        ListNode head = null;

        while(!stack1.isEmpty() && !stack2.isEmpty())
        {
            int sum = stack1.pop() + stack2.pop() + cf;
            ListNode newnode = new ListNode(sum % 10);
            cf = sum / 10;
            newnode.next = head;
            head = newnode;
        }

        while(!stack1.isEmpty())
        {
            int sum = stack1.pop() + cf;
            ListNode newnode = new ListNode(sum % 10);
            cf = sum / 10;
            newnode.next = head;
            head = newnode;
        }

        while(!stack2.isEmpty())
        {
            int sum = stack2.pop() + cf;
            ListNode newnode = new ListNode(sum % 10);
            cf = sum / 10;
            newnode.next = head;
            head = newnode;
        }

        if(cf != 0)
        {
            ListNode newnode = new ListNode(cf);
            newnode.next = head;
            head = newnode;
        }
        return head;
    }
}
