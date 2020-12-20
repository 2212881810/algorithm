package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 18:34
 * @dec 题目2：一个数组中有一种数出现了奇数次， 其他数都出现了偶数次，怎么找到并打印这种数
 */
public class OddEor {
    public static void main(String[] args) {
        // 0 ^ N = N , N^N = 0
        // 同一批数的异或结果与这批数的异或顺序无关
        // eor = 0^1^1^2^3^1^2^4^4^3^3^1 , 4个1异或结果0 ， 2个2 异或结果为0 ，2个4异或结果为0，3个3异或结果为 3
        int[] arr = {1, 1, 2, 3, 1, 2, 4, 4, 3, 3, 1};

        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        System.out.println(eor);
    }
}
