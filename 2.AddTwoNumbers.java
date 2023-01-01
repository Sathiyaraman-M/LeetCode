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
        var node = new ListNode(0);
        var copy = node;
        var carry = 0;
        while(l1 != null || l2 != null || carry == 1) {
            var sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            node.next = new ListNode(sum % 10);
            node = node.next;
            carry = sum > 9 ? 1 : 0;
        }
        return copy.next;
    }
}