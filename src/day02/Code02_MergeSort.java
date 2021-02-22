package day02;

import java.util.Arrays;

/**
 * @Author ZhengQinfeng
 * @Date 2021/1/5 21:38
 * @dec 归并排序 O(N*logN)
 */
public class Code02_MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 9, 6, 2, -1};
        mergeSort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 递归实现
    static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        // 从中点将原数组划分为左右两个数组
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        // 合并
        merge(arr, L, M, R);
    }


    static void merge(int[] arr, int L, int M, int R) {
        // L...M 是左边的数组; M+1 ...R 是右边的数组
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }


        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }

    }


    static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                // L ... M 左组
                int M = L + mergeSize - 1;
                if (M > N) {
                    break;
                }
                // M+1 ... R 右组
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);

                L = R + 1;
            }

            // 防溢出，不让做其做乘以2的操作，防止超过int的最大值
            if (mergeSize > N / 2) {
                break;
            }
            // mergeSize每次乘以2
            mergeSize <<= 1;
        }

    }

}
