package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 19:01
 * @dec 一个数组中有两种数出现了奇数次， 其它都出现偶数次，怎么找到并打印这两种数
 */
public class EvenEor {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 4, 5,3,7};
        printOddTimesNum(arr);

    }

    static void printOddTimesNum(int[] arr) {
        int eor = 0;

        // 假设这两种数是a,b, eor与这个数组中所有的数都异或一遍之后的结果一定是 a^b
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }


        // eor = a^b 且 eor != 0 ,那么eor必然有一位上的数是1

        int rightOne = eor & ((~eor) + 1);      // 找出最右侧的1

        int onlyOne = 0;// eor'
        for (int i = 0; i < arr.length; i++) {

            // 找出数组中rightOne位上也是1的数，这些数里面即包括出现偶数次的数，还会有出现奇数次的数的某一个
            // arr[i]   00001001100100110000
            // rightOne 00000000000000010000
            //    &     00000000000000010000
//            if ((arr[i] & rightOne) == rightOne) {
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];  // 偶数异或的结果为0 ，所以这个onlyOne就是两个奇数中的某一个
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
