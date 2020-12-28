package link;

import java.util.Stack;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/27 21:46
 * @dec 实现一个栈，可以push ,pop ,getMin 【获取栈中的最小值】
 */
public class Code09_StackMinValue {

    public static class MyStack1 {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack1() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int value) {
            if (minStack.isEmpty()) {
                this.minStack.push(value);
            } else if (this.minStack.peek() > value) {
                this.minStack.push(value);
            } else {
                this.minStack.push(this.minStack.peek());
            }
            this.dataStack.push(value);
        }

        public Integer pop() {
            this.minStack.pop();
            return this.dataStack.pop();
        }

        /**
         * 获取栈中最小值
         *
         * @return
         */
        public Integer getMinValue() {
            return this.minStack.peek();
        }
    }
}
