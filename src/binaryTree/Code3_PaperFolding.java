package binaryTree;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/24 23:41
 * @dec 3. 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开。 此时折痕是凹下去的
 * 即折痕突起的方向是指向纸条的背面，如果从纸条的下边向上方连续对折2次，压出折痕后展开，此时有3条折痕，
 * 从上到下依次是下折痕 ，下折痕 ，和上折痕。
 * <p>
 * 给定一个输入参数N, 代表纸条从下边向上方对折N次，请从上到下打印所有折痕的方向。
 * 例如：   N=1时，打印 down
 * N=2时，打印： down down up
 */
public class Code3_PaperFolding {
    /**
     * 纸条对折之后的痕迹其实是二叉树的中序遍历
     * 递归过程 来到某一个节点
     *
     * @param i    ： 节点的层数
     * @param N    ： 一共多少层,纸条对折N层，那么树就有N层
     * @param down ： 表示凹凸， down == true 凹， down ==false 凸
     */
    static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, N, false);
    }


    static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void main(String[] args) {
        printAllFolds(3);

    }
}
