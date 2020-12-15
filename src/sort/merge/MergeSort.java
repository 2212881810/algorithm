package sort.merge;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/14 23:29
 * @dec 归并：左右两个数组必须是排好序的数组
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 3, 8, 9};
//        sortTest(arr);
        sort(arr, 0, arr.length - 1);
        print(arr);
    }


    /**
     * @param arr:  需要进行排序的数组
     * @param begin ： 该数组的开始指针
     * @param end   ： 该数组的结束指针
     */
    public static void sort(int[] arr, int begin, int end) {
        if (begin == end) return;

        // 分成两个数组
//        int mid = end / 2;  // 最开始这样写，出现了死循环，mid = end /2 .后面一想，对于右则的数组而言，求mid值时这样理解明显是不正确了

        int mid = begin + (end - begin) / 2;

        // 左边数组排序
        sort(arr, begin, mid);

        // 右边数组排序
        sort(arr, mid + 1, end);

        // 合并左右两个数组
        merge(arr, begin, mid + 1, end);
    }


    public static void sortTest(int[] arr) {
        // 测试时，
//        merge(arr, 0, 4, 6);  // 表示整个数组进行合并
//        merge(arr,3,4,6);  // 表示只取index[3] 到 index[6]的元素进行归并排序
        merge(arr, 2, 4, 5);  // 3 6 7 8  ,只取了arr中 index[2]到index[5]的元素进行归并排序
    }


    /**
     * @param arr      : 进行合并的数组
     * @param leftPtr  ： 左边数组的开始指针
     * @param rightPtr ： 右边数组的开始指针
     * @param bound    ： 整个要合并的数组边界，不一定就是arr.length,可以是小于length的任意位置
     */
    public static void merge(int[] arr, int leftPtr, int rightPtr, int bound) {
        int mid = rightPtr - 1;
        int i = leftPtr;
        int j = rightPtr;
        // 新数组的起始点
        int k = 0;

        //创建一个新的数组
        int[] temp = new int[bound - leftPtr + 1];


        while (i <= mid && j <= bound) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= bound) {
            temp[k++] = arr[j++];
        }

        // 测试sortTest时注掉
        for (int l = 0; l < temp.length; l++) {
            arr[leftPtr + l] = temp[l]; // 这里为什么是leftPtr+l, 很明显，对于右边的数组，就需要这样，因为它的起始点不是0
        }

        // 测试sort方法时注掉
//        print(temp);

    }


    public static void merge(int[] arr) {
        int mid = arr.length >> 1;  // 取数组的中间值， 7 >> 1 = 3
        int i = 0; // 左边数组的起始的点
        int j = mid + 1;  // 右边数组的起始点
        int k = 0;  // 新数组的起始点

        //创建一个新的数组
        int[] temp = new int[arr.length];

//        while (i <= mid && j < arr.length) {
//            if (arr[i] <= arr[j]) {  // 如果这个加=号，排序算法就会不稳定
//                temp[k] = arr[i];
//                i++;
//                k++;
//            } else {
//                temp[k] = arr[j];
//                j++;
//                k++;
//            }
//        }

        // 对上面while循环中的代码进行优化
        while (i <= mid && j < arr.length) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
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
