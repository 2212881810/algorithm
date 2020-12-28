package link;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/27 20:35
 * @dec 使用数组实现一个固定大小的栈和队列
 */
public class Code08_StackAndQueue {


    public static void main(String[] args) {
//        MyQueue queue = new MyQueue(3);
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//
//        queue.print();
//
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        queue.print();

        System.out.println("=======================");
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());

    }


    /**
     * 使用数组实现一个栈
     */
    public static class MyStack {
        private int[] arr;
        private int index;

        public MyStack(int limit) {
            this.arr = new int[limit];
        }


        public void push(int value) {
            if (index >= arr.length) {
                throw new RuntimeException("栈满了");
            }
            arr[index++] = value;
        }

        public int pop() {
            if (index <= 0) {
                throw new RuntimeException("栈空了,不能再拿元素");
            }
            return arr[--index];
        }


    }







    public static class MyQueue {
        private int[] arr;
        private int pushIndex;
        private int pollIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushIndex = 0;
            pollIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void print() {
            System.out.print("队列：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了");
            }

            size++;
            arr[pushIndex] = value;
            pushIndex = nextIndex(pushIndex);
        }


        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了,不能再拿元素");
            }

            size--;
            int ret = arr[pollIndex];
            pollIndex = nextIndex(pollIndex);
            return ret;
        }

        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }
}
