package sort.quick;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/16 22:28
 * @dec 单轴快排： 取一个数作为轴， 比轴小元素往轴的左边放，比轴大的元素往轴右边放
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 8, 1, 9, 5, 4, 0,10,6};

//        print(arr);

        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return;
        int pivotIndex = partition(arr, leftBound, rightBound);
        sort(arr, leftBound, pivotIndex-1);
        sort(arr, pivotIndex + 1, rightBound);
    }

    static int partition(int[] arr, int leftBound, int rightBound) {
        // 轴
        int pivot = arr[rightBound];

        int leftPtr = leftBound;
        int rightPtr = rightBound - 1;


        while (leftPtr <= rightPtr) {  // 这里一定要有等号， 不然使用对数器时检测时，会出错【数组中只有两个数，比如4，6时，马上就会看到错误】
            // 找出比pivot大的元素的下标
            while (arr[leftPtr] <= pivot && leftPtr <= rightPtr) {
                leftPtr++;
            }

            // 找出比pivot小的元素的下标, 左边是小于等于，那么右边只需要大于即可，不然有bug
            while (rightPtr >= leftPtr && arr[rightPtr] > pivot) {
                rightPtr--;
            }

            // 交换两个元素的位置
            if (leftPtr < rightPtr) swap(arr, leftPtr, rightPtr);
//            print(arr);
        }

        // 交换轴的位置
        swap(arr, leftPtr, rightBound);
        return leftPtr; // 轴的位置
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
