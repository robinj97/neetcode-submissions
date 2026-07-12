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
 // list1 and list2 is null we return list1
 // list2 and list1 is null we return list2
 // While both have:
 // if l1.val < l2.val we add l1 to our list, and we move l1 to l1.next
 // else we add l2 to list and advance l2 to l2.next

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        ListNode merged = new ListNode(0);
        ListNode pointer = merged;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }
        if (list1 != null) {
            pointer.next = list1;
        }
        if (list2 != null) {
            pointer.next = list2;
        }
        return merged.next;
        
    }
}