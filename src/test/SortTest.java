package test;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/12 23:30
 * @dec
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2, 9, 8, 7, 6};
//        selectionSort(arr);
        bubbleSort(arr);
        print(arr);
    }


    /**
     * 冒泡排序： 两两比较，较大的那个元素往后面排
     * <p>
     * 假设数组int arr = new int[n]
     * 第1次外循环之后，最大的元素会移动到int[n], 所以第2次循环只需要比较前n-1个元素即可
     * 第2次外循环之后，最2大的元素会移动到int[n-1],所以第3次循环只需要比较前n-2个元素即可
     *
     * @param arr
     */
    static void bubbleSort(int[] arr) {
        // 因为是两两比较，假设数组中9个元素，只需要比较8次即可
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) { // 因为较大的元素往后排，所以只需要比较数组中前i个元素的大小即可。i后面的元素已排好了序
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }

        }
    }

    /**
     * 选择排序：
     * 比较元素的大小，将最小的元素往数组的最前面放
     *
     * @param arr
     */
    static void selectionSort(int[] arr) {
        /**
         * 第1次外循环之后，找出最小的元素放在数组的arr[0],第2次循环不需要arr[0]参与比较
         * 第2次外循环之后，找出最小的元素放在数组的arr[1],第3次循环不需要arr[0],arr[1]参与比较
         * 第3次外循环之后，找出最小的元素放在数组的arr[2],第4次循环不需要arr[0],arr[1],arr[2]参与比较
         * 第4次外循环之后，找出最小的元素放在数组的arr[3],第5次循环不需要arr[0],arr[1],arr[2],,arr[3]参与比较
         */

        // 最后一个元素不需要比较，所以减1
        for (int i = 0; i < arr.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPosition] > arr[j]) {
                    minPosition = j;
                }
            }
            swap(arr, minPosition, i);
        }

    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
}
