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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int sum = (val1 + val2 + carry);
            int rem = sum % 10;
            ListNode newNode = new ListNode(rem);
            carry = sum >= 10 ? sum / 10 : 0;
            prev.next = newNode;
            prev = newNode;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

        }
        // ListNode remList = l1!=null ? l1 : (l2!=null) ?  l2 : null; 

        //     while(remList!=null)
        //     {
        //         int  sum = remList.val+carry;
        //         int rem = sum%10;
        //         ListNode newNode= new ListNode(rem);
        //         carry =  sum>9 ? sum/10 :0;
        //         prev.next=newNode;
        //         prev=newNode;
        //         remList=remList.next;
        //     }

        //     if  (carry != 0)
        //     prev.next = new ListNode(carry);

        return dummy.next;
    }
}