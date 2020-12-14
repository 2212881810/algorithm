package test;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/14 23:25
 * @dec
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(f(10));
    }

    static int f(int n) {
        if (n < 0) {  //base case
            return -1;
        }


        if (n == 1) { //base case
            return n;
        }


        return n + f(n - 1);  //递归调用
    }
}
