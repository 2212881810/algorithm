package sort.count;

import java.util.Arrays;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/17 22:48
 * @dec 计数排序： 非比较排序 。 适用于数据量大，但数据范围小的情况。 如某公司员工年龄排序
 */
public class CountSort {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 0, 6, 7, 7, 9, 8};
//        int[] result = sort(arr, 0);
                int[] arr = {22, 23, 24, 25, 26, 27, 28, 21, 22, 23, 24, 20, 26, 27, 27, 29, 28};
        int[] result = sort(arr,20);
//        int[] arr = {12, 13, 14, 15, 16, 17, 18, 11, 12, 13, 14, 10, 16, 17, 17, 19, 18};
//        int[] result = sort(arr,10);

        System.out.println(Arrays.toString(result));

//        Arrays.fill(arr, 0);
//        System.out.println(Arrays.toString(arr));

    }

    static int[] sort(int[] arr, int base) {
        // 创建一个新的数组，用于存储排序后的数据
        int[] result = new int[arr.length];

        // 因为原数据的范围是0~9,所以这个计数数组的长度为10
        // count数组的index表示原数组中的数据值，count[index] 表式在原数组中出现的次数
        int[] count = new int[10];


        for (int i = 0; i < arr.length; i++) {
//            int value = arr[i];
//            count[value] = count[value] + 1;
            // 简写
            count[arr[i] - base]++;
        }

        System.out.println(Arrays.toString(count));


        // 这种算法不稳定
//        for (int i = 0, j = 0; i < count.length; i++) {
//            while (count[i]-- > 0) {
//                result[j++] = i + base;
//            }
//        }


        // 下面这种做法是稳定的(累加数组)
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];  // 累加操作
        }
        System.out.println(Arrays.toString(count));
        // 然后对原数组进行倒序操作
        // 注意： 此进的count是个累加数据
        for (int i = arr.length-1; i >=0 ; i--) {
            // -- 是因为数组下标要往前移动一位
            result[--count[arr[i]-base]] = arr[i];
        }





        return result;
    }
}
