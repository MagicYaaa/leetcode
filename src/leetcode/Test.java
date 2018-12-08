package leetcode;

import java.util.List;

/**
 * @program: leetcode
 * @description: 测试用
 * @author: Ya
 * @create: 2018-12-07 11:12
 **/
public class Test {
    public static void main(String[] args){
        GenerateListNode gen = new GenerateListNode();
        ListNode head1 = gen.getListNode(4);
        ListNode head2 = gen.getListNode(4);


        gen.printListNode(head1);
        gen.printListNode(head2);


        Leetcode148 leetcode148 = new Leetcode148();
        head1 = leetcode148.sortList(head1);
        head2 = leetcode148.sortList(head2);
        System.out.println("---排序-----");
        gen.printListNode(head1);
        gen.printListNode(head2);

        System.out.println("---合并俩链表-----");
        ListNode r1 = gen.getEndNode(head1);
        ListNode r2 = gen.getEndNode(head2);

        ListNode mergeList = leetcode148.mergeList(head1,r1,head2,r2);
        gen.printListNode(mergeList);

    }
}
