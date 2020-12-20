package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 21:02
 * @dec 这也太有技巧性了吧。。。。
 */
public class Code01_LinkedListMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    //4. 输入链表头节点，奇数长度返回中点的前一个节点，偶数长度返回下中点的前一个节点
    public static Node midOrDownMidPreNode(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        if (head.next.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }


    //3. 输入链表头节点，奇数长度返回中点的前一个节点，偶数长度返回上中点的前一个节点
    public static Node midOrUpMidPreNode(Node head) {

        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        Node slow = head;

        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }


    //2. 输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head.next;

        Node fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    // 1. 输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node midOrUpMidNode(Node head) {

        // null ,一个节点，两个节点，共计3种情况
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        // 至少有3个节点
        // 慢指针，一次走1步
        Node slow = head.next;

        // 快指针，一次走2步
        Node fast = head.next.next;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
