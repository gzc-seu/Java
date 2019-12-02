package TreeTest;

/**
 * 满二叉树的定义：一个高度为h，并且含有2^h - 1个节点的二叉树称为满二叉树，下文称呼满二叉树为FBT。
 * 根据满二叉树的高度与节点个数之间的关系，很容易判断一棵树是否为FBT，只需要求树其树高和节点个数即可
 */
public class IsFBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCompleteTree(Node head){
        int height=height(head);
        int count=count(head);
        if(count==Math.pow(2, height)-1) return true;
        else return false;
    }

    public static int height(Node head){
        if(head==null) return 0;
        int left=height(head.left);
        int right=height(head.right);
        return Math.max(left,right)+1;
    }

    public static int count(Node head){
        if(head==null) return 0;
        else{
            int left=count(head.left);
            int right=count(head.right);
            return left+right+1;
        }
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

        System.out.println(height(head));
        System.out.println(count(head));
        System.out.println(isCompleteTree(head));
    }

}
