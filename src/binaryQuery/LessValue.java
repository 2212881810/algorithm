package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 17:36
 * @dec 求局部最小：
 * 1） arr[0] < arr[1] : arr[0]是局部最小
 * 2） arr[n-1] > arr[n] : arr[n] 是局部最小
 * 3） arr[i] < arr[i-1] && arr[i] < arr[i+1]  : arr[i] 是局部最小
 * <p>
 * 一个无序数组，相邻元素不相等，
 * <p>
 * 需求： 返回一个局部最小
 */
public class LessValue {

    public static void main(String[] args) {
        int[] arr = {6, 3, 7, 9, 5, 6};
        System.out.println(getLessIndex(arr));
    }

    /**
     * @param arr
     * @return 返回一个局部最小的index
     */
    static int getLessIndex(int[] arr) {


        if (arr == null || arr.length == 0) {
            return -1;// 不存在
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }

        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        // 二分查找
        // 为什么不从left 不等0是因为前0 与1 已经比较过了，rigth同理
        int left = 1;
        int right = arr.length - 2;

        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) >> 1);
//            mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {  // 中间比后面的一个大
                left = mid + 1;
            } else if (arr[mid] > arr[mid - 1]) {  // 中间比前面一个大
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
