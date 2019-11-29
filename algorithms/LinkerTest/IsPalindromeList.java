package LinkerTest;

import java.util.Stack;

/**
判断一个链表是否是回文链表
 */
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    // need n extra space
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack=new Stack<>();
        Node cur=head;
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value) return false;
            head=head.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null) return true;
        Stack<Node> stack=new Stack<>();
        Node fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        while(slow!=null){
            stack.push(slow);
            slow=slow.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value) return false;
            head=head.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null) return true;
        Node fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=Reverse(slow.next);
        while(temp!=null){
            if(temp.value!=head.value) return false;
            temp=temp.next;
            head=head.next;
        }
        return true;
    }
    //反转链表
    public static Node Reverse(Node head){
        if(head == null || head.next == null)
            return head;
        Node pre = head;
        Node pNode = head.next;
        Node next = head;
        //首先处理前两个节点；
        pre.next = null;
        while(pNode != null)
        {
            next = pNode.next;
            pNode.next = pre;
            pre = pNode;
            pNode = next;
        }
        return pre;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");

    }
}
