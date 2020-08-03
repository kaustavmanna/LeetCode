/*
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?
*/

package linkedlist;

import standard.ListNode;

public class RemoveNthNodeFromEndOfList
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode start = head;
        ListNode end = head;

        for(int i = 1; i <= n; i++)
        {
            end = end.next;
            if(end == null)
                return head.next;
        }

        while(end.next != null)
        {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head;
    }
}
