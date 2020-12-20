package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/20 18:54
 * 7. 给定两个可能有环也可能无环的单链表，头节点head1和head2.请实现一个函数，如果两个链表相交，请返回相交的第1个头节点，如果不相交，返回null.
 * 要求： 如果两个链表长度之和为N,时间复杂度请达到O(N), 额外空间复杂度请达到O(1).
 * <p>
 * 注意：单向链表，一个节点只有一个next指针
 * <p>
 * 1个链表有环，一个链表无环，是不可能相交的
 */
public class Code05_FindFirstIntersectionNode {

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    /**
     * 返回两个链表中第1个相交的节点
     *
     * @param head1 ： 第1个链表的头节点
     * @param head2 ： 第2个链表的头节点
     * @return 两个链表的第1个相交节点
     */
    public static Node getIntersectionNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        // 入环节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }

        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }

        // 1个有环，1个无环，不可能相交

        return null;


    }

    /**
     * 找到链表的第1个入环节点，如果无环，返回null
     *
     * @param head 头节点
     * @return 第1个入环节点
     */
    static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node fast = head.next.next; // 快指针，一次两步 。 快指针起点
        Node slow = head.next; // 慢指针，一次一步。 慢指针起点


        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        }


        // 快指针从头开始走，每次走一步， 慢指针接着之前的位置往后走，每次仍然走一步
        fast = head;
        while (fast != slow) {  // 相等时，就是第1次入循环的节点【原理不知道】
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 如果两链表都无环，返回第1个相交节点，如果不相交，返回null.
     *
     * @param head1 : 第1个链表的头节点
     * @param head2 ：第2个链表的头节点
     * @return 两个链表的相交节点
     */
    static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;

        // 算出head1有多少个节点
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        // 如果两个无环链表相交，那么尾节点一定相同
        if (cur1 != cur2) { // 相链表的尾节点不相同
            return null;
        }

        // 此时的n等链表1减云链表2的长度
        cur1 = n > 0 ? head1 : head2; // 两链表谁长，就把谁定义成了cur1
        cur2 = cur1 == head1 ? head2 : head1;// 另一个链定义成cur2,即短的链表定义成cur2

        n = Math.abs(n);
        while (n != 0) {  // 长的链表cur1先走n步
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {  // 相等时就是第1个相交的节点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }


    /**
     * 两个有环链表，返回第1个相交节点，如果不相交返回null 【两个有环链表相交，一定共用同一个环】
     *
     * @param head1 第1个链表的头节点
     * @param loop1 第1个链表的第1个入环节点
     * @param head2 第2个链表的头节点
     * @param loop2 第2个链表的第2个入环节点
     * @return 两个链表的第1个相交节点
     */
    static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {

        Node cur1 = null;
        Node cur2 = null;

        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;

            while (cur1 != loop1) { // 遇到loop就停
                n++;
                cur1 = cur1.next;
            }

            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }


            cur1 = n > 0 ? head1 : head2; // 长的链表标识为cur1
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);

            //长链表cur1先走n步
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }

            // 两个链头同时往下走，第1个相交点停止
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) { // 链表1在环上转一圈
                if (cur1 == loop2) {  // 链表在转的过程中遇到了loop2, 返回loop1,或者loop2都可以，都可以看成是第1个相交节点。
                    return loop1;
                }
                cur1 = cur1.next;

            }
            return null;
        }
    }

}
