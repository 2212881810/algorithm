package sort.merge;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/14 23:29
 * @dec 归并：左右两个数组必须是排好序的数组
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 3, 8, 9};
        sort(arr);
    }

    public static void sort(int[] arr) {
        merge(arr);
    }

    public static void merge(int[] arr) {
        int mid = arr.length >> 1;  // 取数组的中间值， 7 >> 1 = 3
        int i = 0; // 左边数组的起始的点
        int j = mid + 1;  // 右边数组的起始点
        int k = 0;  // 新数组的起始点

        //创建一个新的数组
        int[] temp = new int[arr.length];

        while (i <= mid && j < arr.length) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // 将左边数组剩余的元素直接拷贝到temp数组的尾部
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 将右边数组剩余的元素直接拷贝到temp数组尾部
        while (j < arr.length) {
            temp[k++] = arr[j++];
        }
        print(temp);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
