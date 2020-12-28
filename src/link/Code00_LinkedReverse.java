package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 22:36
 * @dec 单向链表逆序
 */
public class Code00_LinkedReverse {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode{
        int value;
        //上1个节点
        DoubleNode pre;
        
        //下1个节点
        DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        testNode();
        testDoubleNode();

    }

    static void testDoubleNode() {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);

        node1.next = node2;
        node2.pre = node1;
        node2.next = node3;
        node3.pre = node2;
        printDoubleNode(node1);
        DoubleNode doubleNode = doubleNodeReverse(node1);
        printDoubleNode(doubleNode);
    }


    static void testNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        print(node1);
        Node node = reverse(node1);
        print(node);
    }

    /**
     * 双向链表反转
     * @param head
     * @return 新链表的头
     */
    static DoubleNode doubleNodeReverse(DoubleNode head) {

        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;

            head.pre = next;// 下一个变成上一个节点
            head.next = pre; // 上一个变成下一个节点
            pre = head;

            head = next;
        }

        return pre;
    }


    /**
     * 单向链表反转
     * @param head
     * @return 新链表的head
     */
    static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;  // 上一个节点变成下一个节点
            pre = head;
            head = next;
        }
        return pre;
    }



    static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
        ;
    }


    static void printDoubleNode(DoubleNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
        ;
    }
}
