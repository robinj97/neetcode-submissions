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
 // 0 1 2 3 4 5 6
 // 0 6 5 4 3 2 1
 // 0 6 1 2 3 4 5
 // 0 6 1 5 4 3 2
 // 0 6 1 5 2 3 4
 // 0 6 1 5 2 4 3

 // Create an arrayList and have two pointers
 // 0 1 2 3 4
 //   .    .
 //0 4

class Solution {
    public void reorderList(ListNode head) {
        ListNode copy = head;
        List<Integer> array = new ArrayList<>();
        List<Integer> zigzag = new ArrayList<>();
        while (copy != null) {
            array.add(copy.val);
            copy=copy.next;
        }
        for (int left=0,right=array.size()-1;left<=right;left++,right--) {
            if (left == right) {
                zigzag.add(array.get(left));
            } else {
                zigzag.add(array.get(left));
                zigzag.add(array.get(right));
            }
        }
        ListNode current = head;
        for (int value : zigzag) {
            current.val = value;
            current = current.next;
        }
    }

    private ListNode fromArray(List<Integer> array) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int i=0;i<array.size();i++) {
            ListNode toSet = new ListNode(array.get(i));
            current.next = toSet;
            current = current.next;
        }
        return dummy.next;
    }

}
