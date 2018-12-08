package leetcode;

/**
 * @program: leetcode
 * @description: 生成链表
 * @author: Ya
 * @create: 2018-12-07 11:13
 **/
public class GenerateListNode {
    ListNode head = null; //当前链表头
    ListNode tail = null; //表尾结点

    //增加一个结点
    public void addNode(int val){
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        }else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    //获取链表
    public ListNode getHead(){
        return head;
    }

    //获取链表表尾结点
    public ListNode getEndNode(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    //生成一个随机数链表
    public ListNode getListNode(int num) {
        ListNode head = new ListNode((int) (Math.random() * 100));
        ListNode p = head;
        while (num > 1) {
            p.next = new ListNode((int) (Math.random() * 100));
            p = p.next;
            num--;
        }
        return head;
    }

    //打印链表
    public void printListNode(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.print(head.val);
        System.out.println();
    }
}
