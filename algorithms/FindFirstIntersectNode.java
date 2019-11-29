package LinkerTest;

/**
 * 两个单链表相交的问题
 * 给定两个可能有环也可能无环的单链表及其头节点，如果两个链表相交返回第一个相交的节点，若不相交返回null
 */
public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    // 找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head){
        Node fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) break;
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    // 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
    //判断两个链表谁长谁短，长的链表指针先走长度差值，再一起走，相遇处即为第一个相交节点
    public static Node noLoop(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int count=0;  //链表1长度减去链表2长度
        while(cur1!=null){
            count++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            count--;
            cur2=cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1=count>0?head1:head2; //长的链表为cur1，短的为cur2
        cur2=count>0?head2:head1;
        count = Math.abs(count);
        while(count!=0){
            count--;
            cur1=cur1.next;
        }
        while(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    // 两个有环链表，返回第一个相交节点，如果不想交返回null
    /*   不想交
    |_____   |_____
    |     |  |     |
    |_____|  |_____|
     */
    /*  入环节点一样，但第一个相交节点不是入环处,未入环已经相遇
    \   /
     \ /
      |_____
      |     |
      |_____|
     */
    /* 入环节点不一样
    \      /
    _\____/_
    |      |
    |______|
     */

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        if(loop1==loop2){  //第二种情况
            cur1 = head1;
            cur2 = head2;
            int count=0;  //链表1长度减去链表2长度
            while(cur1!=loop1){
                count++;
                cur1=cur1.next;
            }
            while(cur2!=loop2){
                count--;
                cur2=cur2.next;
            }
            if (cur1 != cur2) {
                return null;
            }
            cur1=count>0?head1:head2; //长的链表为cur1，短的为cur2
            cur2=count>0?head2:head1;
            count = Math.abs(count);
            while(count!=0){
                count--;
                cur1=cur1.next;
            }
            while(cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{ //第一和第三种情况
            cur1=loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2) return loop1;
                cur1=cur1.next;
            }
            return null;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //如果一个有环一个无环，一定不会相交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
