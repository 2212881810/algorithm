package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 16:18
 * @dec 通过二分查找，判断有序数组中是否存在某个元素
 *
 * n * 2 可以写成 位移运算 n << 1
 * n * 2 + 1 可以写成 位移运算 ( n << 1 ) | 1
 *
 *
 *
 *
 *
 */
public class ExistNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(exist(arr, 5));
    }

    static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int left = 0;
        int right = sortedArr.length - 1;

        int mid = 0;


        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            }

            if (sortedArr[mid] < num) {
                left = mid + 1;
            }

            if (sortedArr[mid] > num) {
                right = mid - 1;
            }
        }
        System.out.println("left = " + left);
        return sortedArr[left] == num;
    }
}
