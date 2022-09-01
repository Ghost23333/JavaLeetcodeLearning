package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 删除链表的倒数第N个节点.java
 * @Description TODO
 * @createTime 2022年03月09日 20:52:00
 */
public class 删除链表的倒数第N个节点 {
}

//快慢指针
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,slow = head;
        while(n-- > 0){
            fast = fast.next;
        }
        if(fast == null)
            return slow.next;
        while (fast.next !=null){
            fast = fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}