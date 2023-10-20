package org.example.medium.lc19;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> visit = new ArrayList<>();
        ListNode start = head;

        while (start != null) {
            visit.add(start);
            start = start.next;
        }

        int size = visit.size();
        int target = size - n;

        System.out.println("size =" + size);

        if ((target == 0) && (size == 1)) {
            return null;
        } else if ((target == 0) && (size > 1)) {
            return visit.get(target+1);
        } else {
            ListNode previousNode = visit.get(target-1);
            ListNode deleteNode = visit.get(target);
            previousNode.next = deleteNode.next;
            return head;
        }
    }
}