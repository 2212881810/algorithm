package link;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/20 18:54
 * @dec random 指针是单链表结构中新增的指针，random可能指向链表中的任意一个节点，也可能指向NULL.
 * <p>
 * 给定一个由Node节点类型组成的无环单链表的头节点head,请实现一个函数完成这个链头的复制，并返回复制的新链表的头节点
 * <p>
 * 要求： 时间复杂度O(N), 额外空间复杂度O(1)
 */
public class Code04_linkedListRandom {

    public static class Node {
        int value;
        Node next;
        /**
         * 随机指针
         */
        Node random;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * 人为构造对应关系
     * 原： 1 -> 2 -> 3 -> null
     * <p>
     * 构造： 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
     * <p>
     * 再拆分出： 1' -> 2' -> 3' -> null
     *
     * @param head
     * @return
     */

    static Node copyListWithRandom2(Node head) {
        if (head == null) {
            return null;
        }


        Node cur = head;
        Node next = null;

        // 1.克隆节点，而且克隆节点都挂在原节点的后面
        while (cur != null) {
            next = head.next;
            // 克隆出cur的新节点，挂在cur节点之后
            cur.next = new Node(cur.value);
            // 将克隆出的新节点next 指针指向原cur的next节点
            cur.next.next = next;
            cur = next;
        }

        cur = head; // 老节点
        Node curCopy = null;

        // 2.设置克隆节点的random指针
        while (cur != null) {
            next = cur.next.next; // 老节点的下一个节点，因为是1、1', 2、2' 一对一对的处理，对于老节点来说，跳了一个节点
            curCopy = cur.next;// cur的克隆节点
            //  1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
            // 假设1节点的random指针是2， 那么1'的random指针就是2的next节点
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }




        // 3. 以下代码是拆分链表操作 split
        Node res = head.next;  //克隆节点的头节点

        cur = head;
        while (cur != null) {
            next = cur.next.next;  // 记录下一次循环的节点
            curCopy = cur.next;

            //  1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
            //  1-> 2 -> 3
            cur.next = next;  // 改变了老节点的 next指针

            //  1 -> 1' -> 2 -> 2' -> 3 -> 3' -> null
            //  1'-> 2' -> 3'
            curCopy.next = next != null ? next.next : null;  // 改变了克隆节点的next指针
            cur = next;
        }

        return res;
    }


    /**
     * 通过hash表实现的
     *
     * @param head
     * @return 克隆后的头节点
     */
    static Node copyListWithRandom1(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 将所有节点的映射关系存储在map中
        while (cur != null) {
            // put(老节点，老节点克隆出来的新节点)
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }

        // 绑定关系

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);// 返回复制后的头节点
    }
}
