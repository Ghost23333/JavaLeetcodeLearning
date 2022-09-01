package com.ch.array.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int val){this.val = val;this.next = null;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode ll = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l.next = ll;
        ll.next = l3;
        l3.next = l4;
        l4.next = null;
        //Solution s = new Solution();
        //s.deleteNode(ll);
        while(l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}


//234回文链表、
//解法一 先将前半段存到数组再将前半段和后半段对比
/*class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        if(head.next == null)
            return true;
        ListNode tail = head;
        int len =0;
        while(tail.next != null) {
            tail = tail.next;
            len++;
        }
        len++;
        int []pre = new int[len/2 + 1];
        for(int i =0;i<len/2;i++) {
            pre[i] = head.val;
            head = head.next;
        }
        if(len % 2 >0)
           head = head.next;
        for(int i = len/2 - 1;i>=0;i--)
        {
            if(pre[i] != head.val)
                return false;
            head = head.next;
        }
        return true;
    }
}*/
//解法二 快慢指针，并将前半段链表反转
/*
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head ==null || head.next == null)
            return true;
        ListNode fast = head,slow = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast=fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //链表长度为奇数的情况
        if(fast != null) {
            slow = slow.next;
        }
        while(pre!=null&&slow!=null) {
            if(pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}*/


//21 合并两个有序链表
/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        ListNode res ;
        if(l1.val < l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        }
        else{
            res = new ListNode(l2.val);
            l2= l2.next;
        }
        ListNode temp = res;
        while(l1!=null&&l2!=null) {
            if(l1.val < l2.val){
                ListNode newNode = new ListNode(l1.val,null);
                res.next = newNode;
                res = newNode;
                l1 = l1.next;
            }
            else{
                ListNode newNode = new ListNode(l2.val,null);
                res.next = newNode;
                res = newNode;
                l2 = l2.next;
            }
        }

        if(l1 == null)
            res.next = l2;
        if(l2 ==null)
            res.next =l1;
        return temp;
    }
}
*/

//递归实现
/*
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return  l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1,l2.next);
            return  l2;
        }
    }
}*/

//83 删除链表中所有重复的元素

//解法一 将链表的所以数存入set
/*class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head,pre=head;
        HashSet<Integer> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head.val)) {
                pre.next = head.next;

            }
            else {
                set.add(head.val);
                pre = head;
            }
            head =head.next;

        }
        return temp;
    }
}*/

//解法二
/*class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head, pre = head;
        head = head.next;
        while(head !=null) {
            if(head.val == pre.val){
                pre.next = head.next;
            }
            else{
                pre =head;
            }
            head = head.next;
        }
        return temp;
    }
}*/



//141 给定一个链表，判断链表中是否有环。

//解法一快慢指针
/*
class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        ListNode slow =head,fast =head.next;
        while(fast != slow) {
            if(fast ==null || fast.next ==null)
                return false;
            fast =fast.next.next;
            slow=slow.next;
        }
        return true;
    }
}*/


//160相交链表
/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB ==null)
            return null;
        ListNode you = headB,me = headA;
        while(me != you) {
            me = me == null ? headB : me.next;
            you = you == null ? headA:you.next;
        }
        return you;
    }
}*/


//203移除链表元素
//建立哨兵节点
/*
class Solution {
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
*/


//206 反转链表
//迭代
/*class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = new ListNode(head.val);
        head = head.next;
        while(head != null){
            ListNode cur = new ListNode(head.val);
            cur.next = pre;
            pre = cur;
            head = head.next;
        }
        return pre;
    }
}*/
//递归
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }
}*/


//237删除链表中特定节点
/*
class Solution {
    public void deleteNode(ListNode node) {
        node.val =node.next.val;
        node.next = node.next.next;
    }
}*/
//剑指offer22 删除链表中特定节点
/*
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null || head.next ==null)
            return null;
        if(head.val == val)
            return head.next;
        ListNode pre = head,cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
*/

//剑指offer22 返回链表中倒数第K个节点
//快慢指针
/*
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow=head,fast = head;
        for(int i = 0;i<k;i++) {
            if (fast == null)
                return null;
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}*/