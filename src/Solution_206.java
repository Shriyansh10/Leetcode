// 206. Reverse Linked List
    
//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach : Iterative
// TC: O(n) SC: O(1)
public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode prev = null;
        while (head!=null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head=prev;
        return head;
    }
}
