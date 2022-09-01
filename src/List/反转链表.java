package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 反转链表.java
 * @Description TODO
 * @createTime 2020年12月04日 21:31:00
 */
public class 反转链表 {
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }
}

//递归实现
class Solution206{
    public ListNode reverseList(ListNode head) {
        if(head == null||head.next==null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next=null;
        return newHead;
    }
}