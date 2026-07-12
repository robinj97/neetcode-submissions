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

// We need to first reverse the list
 // Create dummy of the linkedList
 // iterate over head until we reach the nth element.
 // Skip adding that to the list

 //Edge cases if n=1 we return empty

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n==1 && head.next == null) {
            return null;
        }
        List<Integer> nodesArray = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodesArray.add(current.val);
            current = current.next;
        }
        List<Integer> onceRemoved = new ArrayList<>();
        int removeIndex = nodesArray.size() - n;
        
        for (int i=0;i<nodesArray.size();i++) {
            if (i != removeIndex) {
                onceRemoved.add(nodesArray.get(i));
            }
        }
        ListNode returnNode = new ListNode(0);
        ListNode pointer = returnNode;
        for (int value : onceRemoved) {
            ListNode toAdd = new ListNode(value);
            pointer.next = toAdd;
            pointer = pointer.next;
        }
        return returnNode.next;
    }
}
