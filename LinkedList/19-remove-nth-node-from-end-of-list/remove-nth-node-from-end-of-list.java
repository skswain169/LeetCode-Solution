/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr=head;
        int length=0;
        while(curr!=null)
        {
            curr=curr.next;
            length++;
        }

        int pos=length-n, index=0;

        curr=head;
        ListNode prev=new ListNode(0,head),next=null,dummy=prev;
        while(curr!=null)
        {
            next=curr.next;
            if(pos==index)
            {
                prev.next=next;
                curr.next=null;
                break;
            }
            
            
            prev=curr;
            curr=next;
            index++;

        }


        return dummy.next;
    }
}