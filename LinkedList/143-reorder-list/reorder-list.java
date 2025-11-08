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
    public void reorderList(ListNode head) {


     ListNode slow=head, fast=head.next;

    //Find middle of list
     while(fast!=null && fast.next!=null)
     {
        slow=slow.next;
        fast = fast.next.next;

     }   

     ListNode second=slow.next; //Start of 2nd list
     slow.next=null; //break contact b/w list

     //reverse list
     ListNode prev=null,next=null;

     while(second!=null)
     {
        
         next=second.next;
         second.next=prev;
         prev=second;
         second=next;
         

     }

     second=prev;//Reassign head for reverse list
     ListNode first=head,next2=null;;
     next=null;

     //Merge two list
      while(second!=null)
      {
        next = first.next;
        next2= second.next;
        first.next =second;
        second.next=next;
        first=next;
        second=next2;
      }  

        
    }

    //public ListNode reverseList()
}