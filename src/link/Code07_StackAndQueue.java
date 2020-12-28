package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/27 20:02
 * @dec 用双链表实现一个栈和队列
 */
public class Code07_StackAndQueue {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        System.out.println("====================================");
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public static class MyQueue<T> {
        private NodeEndQueue<T> queue;

        public MyQueue() {
            queue = new NodeEndQueue<T>();
        }

        public void push(T value) {
            this.queue.addFromTail(value);
        }

        public T pop() {
            return this.queue.popFormHead();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

    }


    public static class MyStack<T> {
        private NodeEndQueue<T> stack;

        public MyStack() {
            stack = new NodeEndQueue<T>();
        }

        public void push(T value) {
            this.stack.addFromTail(value);
        }

        public T pop() {
            return this.stack.popFormTail();
        }

        public boolean isEmpty() {
            return this.stack.isEmpty();
        }
    }


    public static class DoubleNode<T> {
        T value;

        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(T value) {
            this.value = value;
        }
    }

    public static class NodeEndQueue<T> {
        // 头节点
        DoubleNode<T> head;

        // 尾节点
        DoubleNode<T> tail;


        public boolean isEmpty() {
            return head == null;
        }

        /**
         * 从头部添加元素
         *
         * @param value
         */
        public void addFormHead(T value) {
            DoubleNode<T> cur = new DoubleNode<>(value);

            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
        }

        /**
         * 从尾部添加元素
         *
         * @param value
         */
        public void addFromTail(T value) {
            DoubleNode<T> cur = new DoubleNode<>(value);
            if (tail == null) {
                head = cur;
            } else {
                tail.next = cur;
                cur.pre = tail;
            }
            tail = cur;
        }

        /**
         * 从头部弹出节点
         *
         * @return
         */
        public T popFormHead() {

            if (head == null) {
                return null;
            }
            DoubleNode<T> cur = this.head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                cur.pre = null;
            }

            return cur.value;
        }

        /**
         * 从尾部弹出节点
         *
         * @return
         */
        public T popFormTail() {
            if (head == null) {
                return null;
            }
            DoubleNode<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre; // 尾节点变成原来尾节点的前1个节点
                tail.next = null;
                cur.pre = null;
            }

            return cur.value;
        }
    }


}
