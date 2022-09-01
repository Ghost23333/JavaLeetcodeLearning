package com.ch.array.List;

public class L725 {
}
class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode [] ans  = new ListNode[k];
        int len = 0;
        ListNode cur = root;
        while(cur!=null){
            len++;
            cur =cur.next;
        }
        //例子root长度为9 k = 4 a = 3,b = 1 ,最后长度就为3 2 2 2
        int a = len / k + 1;
        int b = len % k;
        ListNode head,pre = null;
        for(int i =0;i<b;i++){
            head = root;
            for(int j = 0;j < a;j++){
                pre = root;
                root = root.next;
            }
            pre.next = null;
            ans[i] = head;
        }
        pre = null;
        for(int i = b;i<k;i++){
            head = root;
            for(int j = 0;j < a - 1;j++){
                pre = root;
                root = root.next;
            }
            if(pre != null)
                pre.next = null;
            ans[i] = head;
        }
        return ans;

    }
}