package binaryTree;

import java.util.Stack;

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


    /**
     * 先序打印所有节点值 【头-> 左-> 右】
     */
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
     * 后序打印 【左->右-> 头】
     *
     * @param head
     */
    static void post(Node head) {
        if (head == null) {
            return;
        }
        post(head.left);
        post(head.right);
        System.out.println(head.value);
    }


    /**
     * 使用压栈的方式实例二叉树的先序遍历： 弹出就打印，先压右，再压左
     *
     * @param head
     */
    static void preUsedStack(Node head) {
        System.out.println("pre-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                // 弹出就打印
                Node node = stack.pop();
                System.out.print(head.value + " ");

                // 先压右
                if (head.right != null) {
                    stack.push(head.right);
                }

                // 再压左
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }

    }


    /**
     * 使用压栈的方式实例二叉树的后序遍历： 弹出压入打印栈，先压左，再压右
     *
     * @param head
     */
    static void postUsedStack(Node head) {
        System.out.println("post-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> printStack = new Stack<>();

            stack.add(head);
            while (!stack.isEmpty()) {
                // 弹出时先压到printStack中
                head = stack.pop();
                printStack.push(head);

                // 行压左
                if (head.left != null) {
                    stack.push(head.left);
                }

                // 再压右
                if (head.right != null) {
                    stack.push(head.right);
                }
            }

            while (!printStack.isEmpty()) {
                Node node = printStack.pop();
                System.out.print(node.value + " ");
            }
        }
    }

    /**
     * 后序遍历（难）
     * @param head
     */
    static void postUsedStack2(Node head) {
        System.out.println("pre-order:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && head != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value+" ");
                    head = c;
                }

            }
        }
    }

    /**
     * 中序遍历
     * @param head ： 链表的头节点
     */
    static void midUsedStack(Node head) {

        System.out.print("中序遍历:");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {  // 整条左边界依次入栈
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "");
                    head = head.right;
                }
            }
        }
    }

}
