package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 两两交换链表中的节点.java
 * @Description TODO
 * @createTime 2022年03月08日 20:52:00
 */
public class 两两交换链表中的节点 {
}

/*递归*/
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
