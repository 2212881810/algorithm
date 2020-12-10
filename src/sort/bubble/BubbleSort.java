package sort.bubble;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/10 23:14
 * @dec 冒泡排序： 冒泡排序的实现思路是遍历数组，两两比较，将较大的一个数往后排。
 * 
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 3, 8, 9, 7, 6};
        // 推导过程
//        findMax(arr, arr.length - 1);
//        findMax(arr, arr.length - 2);
//        findMax(arr, arr.length - 3);

        sort(arr);
        print(arr);

    }

    static void sort(int[] arr) {
        // 使用i-- 的原因是,排好序的数据都是往后面的放的
        for (int i = arr.length - 1; i > 0; i--) {
            findMax(arr, i);
        }

    }

    /**
     * 数组arr ,比较max【arr.length-1】次找到最大的那个元素
     *
     * @param arr
     * @param count : 比较次数,例如: arr数组中有5个元素,那么比较4次便能找到最大的元素
     */
    static void findMax(int[] arr, int count) {
        for (int i = 0; i < count; i++) {
            // 相临的两个元素进行比较，大的那个元素往后排
            // 可以看出,始终是从arr最开始的两个元素开始进行比较.
            if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);

        }
    }

    static void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
