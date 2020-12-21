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

// Iterative Solution
class Solution {
    public ListNode reverseList(ListNode head) {

        // Iterative Solution: Reverse pointers!
        // IE 1 -> 2 -> 3 -> 4 -> 5
        //    1 <- 2 <- 3 <- 4 <- 5

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // iterate the whole list
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// recursive solution
class Solution {

    public ListNode reverseList(ListNode head) {
        // base case: if head == null, then we have an empty list
        // other base case: if head.next == null, we've reached the end of our original list
        if(head == null || head.next == null ){
            return head;
        } else {
            // dig to final node in list
            ListNode reversedHead = reverseList(head.next);
            // head is one before reversedList's ending

            head.next.next = head;
            head.next = null;
            return reversedHead;
        }
    }
}