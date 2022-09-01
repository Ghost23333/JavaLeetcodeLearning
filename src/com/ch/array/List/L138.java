package com.ch.array.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class L138 {
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node,Node> map = new HashMap<>();

        Node cur = head;
        while(cur !=null){
            Node newNode = new Node(cur.val);
            map.put(cur,newNode);
            cur = cur.next;
        }
        cur = head;
        while(cur !=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}