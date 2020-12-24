package binaryTree;

/**
 * @Author ZhengQinfeng
 * @Date 2020/12/24 23:17
 * @dec 给你二叉树中的某个节点 ，返回该节点的后继节点。
 * 后继节点： 二叉树中续遍历（左头右）时的下一个节点
 */
public class Code2_SuccessorNode {
    public static class Node {
        int value;
        Node left;
        Node right;
        Node parent;
    }


    /**
     * @param node
     * @return 返回Node节点的后继节点
     */
    static Node getSuccessorNode(Node node) {
        if (node != null) {
            return null;
        }
        if (node.right != null) { // 有右子树
            return getLeftMost(node.right);
        } else { // 无右子树
            Node parent = node.parent;
            while (parent != null && parent.right == node) {  // 当前节点是其父节点的右孩子
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }


    private static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
