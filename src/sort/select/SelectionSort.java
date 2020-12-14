package sort.select;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/9 22:34
 * @dec 选择排序:
 * 思路：
 * 先拿数组的第1个元素同数组的其它元素比较，找到最小那个元素min【下标】，并将min与第1个元素进行位置调换，这样，数组中最小的元素就在数组的首位
 * 再拿数组的第2个元素同数组的其它(后面)元素比较，找到最小那个元素,并将其与数组的第2个元素进行位置调用，这样，数组中第二小的元素就在数组的第二个位置
 * 以此类推....
 * <p>
 * <p>
 * <p>
 * 验证算法： 对数器
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2, 8, 9, 7, 6};
//        sort1();  // 推导过程1
//        sort2();  // 推导过程2
        sort3(arr);   // 最终结果
    }


    /**
     * 由test1,test2可以推算出一个套路，外层应该还有一个for循环，
     * <p>
     * 最终选择排序有两层for循环：
     * 外层for循环表示：循环比较的次数  等于数组长度减1
     * <p>
     * 内层for循环： 找出最小元素的下标
     */
    public static void sort3(int[] arr) {


        for (int j = 0; j < arr.length - 1; j++) {  //因为最后一个元素不需要与其它元素进行比较，后面外层循环的遍历次数是arr.length-1

            int minPos = j;  // 第j次循环，假设的最小元素下标
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[minPos] > arr[i]) {
                    minPos = i;
                }
            }
            // 交换我们假设的最小元素【下标j】 和 真实的最小元素【下标minPos】
            swap(arr, j, minPos);
//            print(arr);
//            System.out.println();
        }

    }


    /**
     * 第2次测试,更进一步
     * <p>
     * test1只是将第1个元素与后面的元素进行排序
     * 现在取第二个元素与后面的元素进行比较排序
     */
    static void sort2() {
        int[] arr = {1, 4, 5, 3, 2, 8, 9, 7, 6};  // 经过test1方法之后，arr已经将最小的元素放在首位


        int minPos = 1;  // 因为从第1个元素开始进行比较

        for (int i = 2; i < arr.length; i++) {  // 因为第1个元素arr[minPos],我们拿来比较的元素， 所以这儿从1开始
            if (arr[minPos] > arr[i]) {  // 这个循环跑完之后，即是将第1个元素与其它元素进行了比较，找到最小元素的位置，即minPos
                minPos = i;
            }
        }
        // 因为我们是用第1个元素与其它元素进行的比较，找到的最小元素位置，所以这儿将第1个元素与最小元素进行位置交换
        // 从而整个数组中，最小的元素放在了arr[0]的位置
        swap(arr, 1, minPos);
        print(arr);
    }


    /**
     * 第1次测试
     */
    static void sort1() {
        int[] arr = {3, 4, 5, 1, 2, 8, 9, 7, 6};
        // 定义一个最小元素下标标识位minPos
        int minPos = 0;  // 因为从第1个元素开始进行比较

        for (int i = 1; i < arr.length; i++) {  // 因为第1个元素arr[minPos],我们拿来比较的元素， 所以这儿从1开始
            if (arr[minPos] > arr[i]) {  // 这个循环跑完之后，即是将第1个元素与其它元素进行了比较，找到最小元素的位置，即minPos
                minPos = i;
            }
        }
        // 因为我们是用第1个元素与其它元素进行的比较，找到的最小元素位置，所以这儿将第1个元素与最小元素进行位置交换
        // 从而整个数组中，最小的元素放在了arr[0]的位置
        swap(arr, 0, minPos);
        print(arr);
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
