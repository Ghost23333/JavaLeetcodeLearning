package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 移除链表元素.java
 * @Description TODO
 * @createTime 2022年03月07日 12:38:00
 */
public class 移除链表元素 {
}


class Solution203{
    public ListNode removeElements(ListNode head, int val) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;

        ListNode cur = head,pre = prehead;
        while(cur != null){
            if(cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return prehead.next;
    }
}