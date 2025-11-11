/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {


    //Copy org list in HM , then traverse HM and assign next,random values
        Node curr=head;
        HashMap<Node,Node> nodeMap = new HashMap<>();

        while(curr!=null)
        {
            Node copy= new Node(curr.val);
            nodeMap.put(curr,copy);
            curr=curr.next;
        }
        
        //here simple Node traversal like above will also work
        // nodeMap.entrySet().stream().
        //     forEach(entry -> {
        //              entry.getValue().next = nodeMap.get(entry.getKey().next);
        //              entry.getValue().random = nodeMap.get(entry.getKey().random);
        //             });

        curr=head;
        while(curr!=null)
        {
            nodeMap.get(curr).next=nodeMap.get(curr.next);
            nodeMap.get(curr).random=nodeMap.get(curr.random);
            curr=curr.next;
        }

    return nodeMap.get(head);

}}