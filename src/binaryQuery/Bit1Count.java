package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 19:24
 * @dec 给定一个int ,计算出它二进制数中1出现的次数
 */
public class Bit1Count {


    public static void main(String[] args) {
        System.out.println(bit1Count(6));
    }


    static int bit1Count(int n) {
        int count = 0;

        // n                :  1111001001001011100000
        //rightOne          :  0000000000000000100000
        // n = n^rightOne   :  1111001001001011000000

        while (n != 0) {
            int rightOne = n & ((~n) + 1);
            count++;
            n ^= rightOne;
        }
        return count;

    }
}
