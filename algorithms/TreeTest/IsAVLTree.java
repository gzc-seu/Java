package TreeTest;

/**
 * 如何判断AVL树：
 * 从根节点开始，先判断左右子树的高度差是否超过1，然后接着判断左右子树是否是平衡二叉树。这边用到了递归思想
 */
public class IsAVLTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int height(Node head){
        if(head==null) return 0;
        int left=height(head.left);
        int right=height(head.right);
        return Math.max(left,right)+1;
    }

    public static boolean IsAVLTree(Node head){
       if(head==null) return true;
       if(Math.abs(height(head.left)-height(head.right))<=1){
           return IsAVLTree(head.left)&&IsAVLTree(head.right);
       }else return false;
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

        System.out.println(IsAVLTree(head));
    }
}
