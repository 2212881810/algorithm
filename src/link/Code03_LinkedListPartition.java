package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 21:02
 * 6. 将单链表按某值划分成左边小，中间相等，右边大的形式。
 * 1） 把链表放入数组里，在数组上做partition（笔试）
 * 2)  分成小中大三部分，再把各部分之间串起来（面试）
 */
public class Code03_LinkedListPartition {
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
        Node node4 = new Node(5);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(4);
        Node node8 = new Node(0);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Node node = listPartition(node1, 3);
        print(node);
    }


    static Node listPartition(Node head, int pivot) {
        // 小于pivot区的头节点
        Node sH = null;
        // 小于pivot区的尾节点
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node next = null;

        // 把每一个节点通过与pivot比较之后，分配到这三个区域去
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {// 去小于区
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;  // 老尾巴的next指向新来的节点
                    sT = head;   //新来的节点成为新尾巴
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;// 新来的节点挂尾部
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }

        // 小于区域的尾巴连等于区域的头，等于区域的尾巴连大于区域的头

        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT;  // 谁去连接大于区域，谁就是et
        }


        if (eT != null) {
            eT.next = bH;
        }


        return sH != null ? sH : (eH != null ? eH : bH);
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
