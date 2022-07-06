// 234. Palindrome Linked List

//   Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Approach: Fast and Slow Pointers for seperating 2 lists and reverse the seconde list then compare return accordingly
// TC: O(n) SC: O(1)
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        int count = 0;
        if(head.next==null){
            return true;
        }
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        fast = head;
        while(count != 1){
            fast= fast.next;
            count--;
        }
        fast.next = null; 
        ListNode temp1 = head;
        ListNode temp2 = reverse(slow);
        boolean flag = true;
        while(temp2!=null && temp1!=null){
            if(temp2.val != temp1.val){
                flag = false;
                break;
            }
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return flag;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        head = prev;
        return head;
    }
}