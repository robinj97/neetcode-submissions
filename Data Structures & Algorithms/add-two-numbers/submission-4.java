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

 // 123,456
 // 321+654=975

 //l2 can be null

 // reverse both.
 // Make into integers and find sum
 // Make sum into a string, and reverse the string

 // loop through string and set node value with charAt

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        ListNode l1Reversed = reverse(l1);
        ListNode l2Reversed = reverse(l2);
        // Turn both into strings, parse as Int and turn back into String DOONT forget to reverse the result again

        StringBuilder s1 = new StringBuilder();
        String node1AsString =nodeToString(l1Reversed,s1);

        StringBuilder s2 = new StringBuilder();
        String node2AsString =nodeToString(l2Reversed,s2);

        int sumAsInt = Integer.parseInt(node1AsString) + Integer.parseInt(node2AsString);
        String sum = String.valueOf(sumAsInt);

        ListNode reversedSum = new ListNode(0);
        ListNode currentPointer = reversedSum;

        for (int i=sum.length()-1;i>=0;i--) {
            char numberAsChar = sum.charAt(i);
            int valueToAdd = Character.getNumericValue(numberAsChar);
            ListNode nodeToAdd = new ListNode(valueToAdd);
            currentPointer.next = nodeToAdd;
            currentPointer = currentPointer.next;
        }
        return reversedSum.next;

        
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private String nodeToString(ListNode head,StringBuilder sb) {
        if (head == null) {
            return sb.toString();
        }
        int value = head.val;
        sb.append(String.valueOf(value));
        return nodeToString(head.next,sb);

    }
}
