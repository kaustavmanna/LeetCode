/*
Given a sorted linked list, delete all duplicates such that each element appear only once.
Example 1:
Input: 1->1->2
Output: 1->2

Example 2:
Input: 1->1->2->3->3
Output: 1->2->3
*/

public class RemoveDuplicatesFromSortedList
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode trav = head;
        trav.next = new ListNode(1);
        trav = trav.next;
        trav.next = new ListNode(2);
        trav = trav.next;
        trav.next = new ListNode(3);
        trav = trav.next;
        trav.next = new ListNode(3);

        trav = deleteDuplicates(head);
        while(trav != null)
        {
            System.out.print(trav.val + " ");
            trav = trav.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head)
    {
        ListNode trav = head;
        while(trav != null)
        {
            if(trav.next != null && trav.val == trav.next.val)
            {
                ListNode temp = trav.next;
                while(temp != null && temp.val == trav.val)
                    temp = temp.next;
                trav.next = temp;
            }
            trav = trav.next;
        }
        return head;
    }
}
