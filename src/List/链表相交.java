package List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 链表相交.java
 * @Description TODO
 * @createTime 2022年03月09日 21:06:00
 */
public class 链表相交 {
}
class Solution0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}

//https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/solution/mian-shi-ti-0207-lian-biao-xiang-jiao-sh-b8hn/

class Solution0207_2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fastA = headA;
        ListNode fastB = headB;
        ListNode slowA = headA;
        ListNode slowB = headB;
        // 先跑一遍最短的链表，此时两链表的快指针一起跑，最终停止时长链表的快慢指针差额就是两个链表长度差
        // 此轮跑了min个节点
        while (fastA != null && fastB != null) {
            fastA = fastA.next;
            fastB = fastB.next;
        }
        // 再把长链表剩下的部分跑一遍，此时长链表的快慢指针一起跑，最终停止时两链表的慢指针和链表尾节点的距离一致
        // 此轮跑了max-min个节点
        if (fastA == null) {
            while (fastB != null) {
                slowB = slowB.next;
                fastB = fastB.next;
            }
        } else if(fastB == null) {
            while (fastA != null) {
                slowA = slowA.next;
                fastA = fastA.next;
            }
        }
        // 最后两链表一起跑，两指针相同时停止，由于长度一致，即使无相交也会在最后同时等于null
        // 此轮最多跑min个节点（无交点时）
        while (slowA != slowB) {
            slowA = slowA.next;
            slowB = slowB.next;
        }
        // 最后返回慢指针即可，一共跑了min+(max-min)+min=max+min个节点
        return slowA;
    }
}