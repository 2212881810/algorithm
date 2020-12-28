package link;

import java.util.Stack;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/27 22:26
 * @dec 用栈实现一个队列的功能【两个栈可以实现一个队列的功能; 两个队列也能实现一个栈的功能】
 */
public class Code10_TwoStackImplementQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    public static class MyQueue {
        private Stack<Integer> pushStack;
        private Stack<Integer> popStack;

        public MyQueue() {
            this.pushStack = new Stack<>();
            this.popStack = new Stack<>();
        }

        private void pushToPop() {
            if (popStack.isEmpty()) { // 只有在pop栈为空的情况下，才可能将pushStack栈中元素push进去
                while (!pushStack.isEmpty()) {
                    this.popStack.push(this.pushStack.pop());
                }
            }
        }

        public void push(Integer value) {
            this.pushStack.push(value);
            this.pushToPop();
        }

        public Integer pop() {
            Integer value = this.popStack.pop();
            this.pushToPop();
            return value;
        }
    }
}
