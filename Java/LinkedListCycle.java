/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;
        if (head.next == null)
            return false;

        ListNode turtle = head;
        ListNode rabbit = head.next;

        while (true) {
            if (rabbit == null)
                return false;
            if (rabbit.next == null)
                return false;

            if (rabbit == turtle)
                return true;

            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
    }
}