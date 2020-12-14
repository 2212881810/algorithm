package sort.shell;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/13 23:08
 * @dec 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
//        sort(arr);
        sort2(arr);
        print(arr);
    }


    /**
     * 优化希尔排序，使用knuth序列
     * @param arr
     */
    public static void sort2(int[] arr) {
        // 使用knuth序列，这个序列效率更高
        int h = 1;
        while (h <= arr.length / 3) {
            h = 3 * h + 1;
        }


        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            // 里面就是一个插排
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) { // 步长是gap ，是因为间隔gap个元素进行比较
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }
                }

            }
        }

    }

    static void sort(int[] arr) {
        for (int k = arr.length >> 1; k > 0; k /= 2) {
            int gap = k;
            //这两层for循环就是插入排序，只不过插排是相临两个元素之间进行比较，而希尔是相临gap元素进行比较
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
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
