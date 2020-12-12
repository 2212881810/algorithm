package sort.insertion;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/12 23:59
 * @dec 插入排序： 从数组的第n个元素开始取值与第n-1个元素进行比较，如果第n个元素比第n-1个元素小，交换位置
 * 效率比冒泡和选择高
 * <p>
 * 冒泡基本不用，太慢
 * 选择基本不用，不稳
 * 插入样本小，基本有序时，效率比较高
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2, 8, 9, 7, 6};
        int[] arr2 = {3, 4, 5, 1, 2, 8, 9, 7, 6};
        sort(arr);
        sort2(arr2);
        print(arr);
        print(arr2);
    }

    static void sort(int[] arr) {
        // 从1开始是因为，第arr[0]前面没有元素，不需要比较
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {  // 与前面的元素进行比较
                if (arr[j] < arr[j - 1]) {  // 如果有一个元素比较前一个元素小，两元素交换位置
                    swap(arr, j - 1, j);
                }
                System.out.println("===================");
            }
        }
    }

    /**
     * 优化
     *
     * @param arr
     */
    static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
                System.out.println("+++++++++++");
            }
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
