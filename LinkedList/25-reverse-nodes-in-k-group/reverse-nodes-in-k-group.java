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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy= new ListNode(0,head);
        ListNode groupPrev = dummy;
        while(true)
        {
            ListNode kth= findKth(groupPrev,k);
            if(kth == null) break;
            ListNode groupNext = kth.next;

            ListNode curr=groupPrev.next, prev=groupNext,next=null;
            while(curr!=groupNext)
            {
                next=curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }
            ListNode newGrpPrev= groupPrev.next;
            groupPrev.next=prev; //or kth 
            groupPrev =newGrpPrev;    
        }

        return dummy.next;
        
    }
    public ListNode findKth(ListNode curr,int k)
    {
        while( curr!=null && k>0)
        {
            curr= curr.next;
            k--;
        }

        return curr;
    }
}