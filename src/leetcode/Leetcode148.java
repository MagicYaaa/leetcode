package leetcode;

/**
 * @program: leetcode
 * @description: 148 排序链表
 * @author: Ya
 * @create: 2018-12-06 23:43
 **/
public class Leetcode148 {
    /**
     * 实现时间复杂度O(logN) 常数空间 需要多路归并
     */
    //有序链表合并
    public ListNode mergeList(ListNode head1, ListNode rail1, ListNode head2, ListNode rail2) {
        ListNode head = null;
        ListNode h1 = head1, h2 = head2;
        if (h1.val < h2.val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }

        ListNode h = head;
        while (h1 != rail1.next && h2 != rail2.next) {
            if (h1.val <= h2.val) {
                h.next = h1;
                h = h1;
                h1 = h1.next;
            } else {
                h.next = h2;
                h = h2;
                h2 = h2.next;
            }
        }
        if (h1 == rail1.next) {
            rail1.next = h2;
        } else {
            rail2.next = h1;
        }
        return head;
    }

    /**
     * 一种链表插入排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = null;
            head = insert(head, cur);
            cur = temp;
        }
        return head;
    }

    //把cur插入到 head合适的位置 结点后面
    ListNode insert(ListNode head, ListNode cur) {
        ListNode p = head;
        if (cur.val < p.val) {
            cur.next = p;
            return cur;
        }
        ListNode pre = p;
        p = p.next;
        while (p != null) {
            if (cur.val < p.val) {
                pre.next = cur;
                cur.next = p;
                return head;
            }
            pre = p;
            p = p.next;
        }
        pre.next = cur;
        return head;
    }

}
