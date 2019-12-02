package TreeTest;

import java.util.LinkedList;

/**
 * 判断是否是一个完全二叉树：
 * 1.任一节点有右无左，不是
 * 2.在不违反1的情况下，遇到的第一个节点左右不双全，则剩下的所有节点都要是叶节点
 */
public class IsCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT(Node head){
        if(head==null) return true;
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf=false;  //是否开启后续叶节点的检查
        Node left,right;
        queue.add(head);
        while(!queue.isEmpty()){
            head=queue.poll();
            left=head.left;
            right=head.right;
            if(left==null&&right!=null) return false;
            if(leaf && !(left== null && right == null)) return false; // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
            if (left != null) {
                queue.add(left);
            }
            if (right!= null) {
                queue.add(right);
            }
            if (left == null || right== null) {
                leaf = true; //此时出现了点左右不双全的情况，要检查叶节点
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        System.out.println(isCBT(head));

    }
}
