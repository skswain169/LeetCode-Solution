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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        
        while (lists.length > 1) {
            List<ListNode> combinedList = new LinkedList();

            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i < lists.length - 1) ? lists[i + 1] : null; //if 2nd list exists

                ListNode mergeListHead = mergeList(l1, l2);
                combinedList.add(mergeListHead);

            }
            lists = combinedList.toArray(new ListNode[0]);
        }

        return lists[0];

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;

            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        if (l1 != null)
            temp.next = l1;
        if (l2 != null)
            temp.next = l2;

        return dummy.next;
    }
}