package sort;

import sort.merge.MergeSort;
import sort.select.SelectionSort;
import sort.shell.ShellSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/9 23:40
 * @dec  对数器
 */
public class DataChecker {
    /**
     * 生成随机数组
     * @return
     */
    static int[] generateRandomArr() {
        Random random = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    static boolean check(int[] arr) {
        int[] checkArr = new int[arr.length];
        System.arraycopy(arr, 0, checkArr, 0, arr.length);

        Arrays.sort(arr);  // jdk提供的排序算法

//        SelectionSort.sort3(checkArr);

//        ShellSort.sort2(checkArr);
        MergeSort.sort(checkArr,0 , checkArr.length -1);

        // 比较
        for (int i = 0; i < checkArr.length; i++) {
            if (arr[i] != checkArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = generateRandomArr();
        System.out.println(check(arr));


    }
}
