package day02;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/28 23:04
 * @dec  求数组 arr, L,R范围之间的最大值
 *
 * O(N)
 */
public class Code01_GetMaxValue {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 8, 5, 6, 7, 13, 20};
        System.out.println(getMax(arr, 2,5));
        System.out.println(getMax(arr, 0,arr.length-1));
    }

    /**
     * 时间复杂度O(N)
     * @param arr
     * @param L
     * @param R
     * @return
     */
    static int getMax(int[] arr,int L ,int R) {
        if (L == R) {
            return arr[L];  // base case
        }

        int mid = L + ((R - L) >> 1);  // 注意括号
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);

    }
}
