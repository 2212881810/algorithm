package link;

import java.util.Stack;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 21:02
 * @dec 判断一个链表是不是回文链表
 */
public class Code02_LinkedListPalindrome {
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
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        System.out.println(isPalindrome1(node1));
//        System.out.println(isPalindrome2(node1));
        print(node1);
        System.out.println(isPalindrome3(node1));


    }


    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {  // find mid node
            n1 = n1.next;// mid node
            n2 = n2.next.next; // end node
        }

        n2 = n1.next;  // 此时，n2: 2->1
//        print(n2);
//
//
//        System.out.print("n1 = ");
//        print(n1);  // 3->2->1

        n1.next = null;  // 此时，n1 = 3 , n1.next = null


        // n1 : 3
        // n2 : 2->1

        Node n3 = null;
        while (n2 != null) {  // 右半部分逆序
            n3 = n2.next;  // 1
            n2.next = n1;  // 3
            n1 = n2;    // 3
            n2 = n3;   // 1
        }

        n3 = n1;
        n2 = head;
        print(n2);
        boolean res = true;
        while (n1 != null && n2 != null) {  // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {  // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

    // need n/2 extra space
    public static boolean isPalindrome2(Node head) {

        // 只有一个节点
        if (head == null || head.next == null) {
            return true;
        }


        Node right = head.next;  // 链表慢指针

        Node fast = head;  // 从这里看出，快指针的开始位置很灵活，它快，主要还是因为while循环里面每次移两步，最开始理解有偏差

        while (fast.next != null && fast.next.next != null) {
            right = right.next;
            fast = fast.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        // 入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }


        while (head != null) {
            // 比较
            if (head.value != stack.pop().value) {
                return false;
            }

            head = head.next;
        }
        return true;
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
