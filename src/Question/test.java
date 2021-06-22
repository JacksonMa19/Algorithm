package Question;

import java.util.Stack;

public class test {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return  l2;
        }
        if (l2 == null) return  l1;

        ListNode node = new ListNode(0);
        ListNode work = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                work.next = l1;
                l1 = l1.next;
            } else {
                work.next = l2;
                l2 = l2.next;
            }
            work= work.next;
        }
        work.next = l1==null?l2:l1;
        return node.next;


    }

    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (head != null) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }



    public static void main(String[] args) {

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
