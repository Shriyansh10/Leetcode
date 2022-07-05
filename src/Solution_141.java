// 141. Linked List Cycle

// ListNode class is commented
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// Approach: Fast and Slow Pointers
// TC: O(n) SC: O(1)
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            } 
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}