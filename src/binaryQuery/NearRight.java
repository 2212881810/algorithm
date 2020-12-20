package binaryQuery;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/19 16:36
 * @dec 在一个有序的arr中，找满足 <= value 的最右位置
 */
public class NearRight {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8, 9};
        System.out.println(nearestRightIndex(arr, 8));
    }

    static int nearestRightIndex(int[] sortedArr, int num) {

        int index = -1; // 记录最右边的位置


        if (sortedArr == null || sortedArr.length == 0 || sortedArr[sortedArr.length - 1] < num) {
            return index;
        }

        int left = 0;
        int right = sortedArr.length - 1;
        int mid = 0;


        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (sortedArr[mid] <= num) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index;

    }
}
