package algorithms.base.linkedlist;

public class Test {
    public static boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode prePointer = head;
        ListNode slowPointer = head.next;
        ListNode fastPointer = head.next.next;
        while(null != fastPointer && null!= fastPointer.next ) {
            fastPointer = fastPointer.next.next;
            ListNode temp = slowPointer;
            slowPointer = slowPointer.next;
            temp.next = prePointer;
            prePointer = temp;
        }
        if (null != fastPointer) {
            slowPointer = slowPointer.next;
        }
        while (null != slowPointer && null != prePointer) {
            if (slowPointer.val != prePointer.val) {
                return false;
            } else {
                slowPointer = slowPointer.next;
                prePointer = prePointer.next;
            }
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fasterPointer = head;
        while (null != fasterPointer && null != fasterPointer.next) {
            slowPointer = slowPointer.next;
            fasterPointer = fasterPointer.next.next;
            if (slowPointer == fasterPointer) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(isPalindrome(l1));

    }
}
