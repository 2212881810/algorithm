package binaryTree;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/20 23:25
 * @dec 二叉树遍历
 */
public class Code01_Recursive {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    // 先序打印所有节点值 【头-> 左-> 右】
    static void pre(Node head) {

        if (head == null) {
            return;
        }

        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 中序打印【左->头-> 右】
     *
     * @param head
     */
    static void mid(Node head) {
        if (head == null) {
            return;
        }

        mid(head.left);
        System.out.println(head.value);
        mid(head.right);

    }


    /**
     * 后序打印 【右->左-> 头】
     *
     * @param head
     */
    static void post(Node head) {

        if (head == null) {
            return;
        }
        post(head.right);
        post(head.left);
        System.out.println(head.value);
    }
}
