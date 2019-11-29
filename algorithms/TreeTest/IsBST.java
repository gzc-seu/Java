package TreeTest;

import java.util.Stack;

/**
 * 判断是否是二叉搜索树：中序遍历序列非降
 */
public class IsBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean IsBST(Node head){
        int precount=0,nowcount;
        if(head!=null){
            Stack<Node> stack = new Stack<Node>();
            while(!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head=head.left;
                }else{
                    head=stack.pop();
                    nowcount=head.value;
                    if(nowcount<precount) return false;
                    precount=nowcount;
                    head=head.right;
                }
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

        System.out.println(IsBST(head));

    }
}
