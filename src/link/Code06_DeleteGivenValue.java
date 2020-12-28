package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/27 19:34
 * @dec 删除链表与给定值相等的节点,有可能删除的就是头节点，所以需要返回新链表的头节点
 */
public class Code06_DeleteGivenValue {
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
        Node node = deleteValue(node1, 3);
        print(node);
    }

    static Node deleteValue(Node head, int num) {

        // 如果链表头部等于num 直接删掉
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }


        // head来到第1个不需要删除的位置
        Node pre = head;
        Node cur = head;

        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;  // 删除cur节点
            } else {
                pre = cur;  //移动cur节点的前1个节点pre.
            }
            cur = cur.next;
        }

        return head;

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
