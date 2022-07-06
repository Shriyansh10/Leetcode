// 876. Middle of the Linked List

//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
// Approach: Fast and Slow Pointers
// TC: O(n) SC:O(1)
public class Solution_876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head ,fast = head;
        while (fast!= null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}