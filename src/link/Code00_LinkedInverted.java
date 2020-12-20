package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 22:36
 * @dec 单向链表逆序
 */
public class Code00_LinkedInverted {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
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
//        Node reverse = reverse2(node1);
//        print(reverse);


//        deleteNode(node3);
//        Node result = reverse3(node1);
//        print(result);

        Node node = reverse2(node1);
        print(node);

    }

    /**
     * 删除单链表的某个节点
     * 我感觉这并不是真正的删除node节点，这只是一种表象删除
     *
     * @param node
     */
    static void deleteNode(Node node) {
        Node next = node.next;
        node.value = next.value;
        node.next = next.next;
    }





    /**
     * 这种方式好像更容易理解
     * @param head
     */
    static Node reverse2(Node head) {
        // 拿到尾节点
        Node tail = head;
        Node next = head.next;
        tail.next = null;  // 干掉尾巴

        Node temp = null;

        while (next != null) {
            temp = next.next; // 临时存储，下一次while循环的后续节点

            next.next = tail;
            tail = next;

            next = temp;
        }

        return tail;
    }


    /**
     * 这种方式并没有reverse2好理解
     * @param head
     * @return
     */

    static Node reverse3(Node head) {
        Node tail = head;
        Node temp = null;
        while (head.next != null) {
            temp = head.next;
            head.next = head.next.next;  // 相当于删除了next节点
            temp.next = tail;
            tail = temp;
        }
        return tail;
    }



    private static Node reverse(Node head) {
        Node p1, p2 = null;
        p1 = head;

        // 每1次循环，p2就是head的next节点，
        // p2.next = p1 ,就相当是把 p1-> p2 变成了 p2 -> p1, 再下一次循环： p3->p2->p1
        while (head.next != null) {
            p2 = head.next;
            head.next = head.next.next; // head.next = head.next.next

            p2.next = p1;
            p1 = p2;

        }
        return p1;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
        ;
    }
}
