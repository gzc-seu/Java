package LinkerTest;

/**
 * 给定一个值A，把链表中小于A的值放左边，等于A的放中间，大于A得放右边
 */
public class SmallerEqualBigger {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    //把链表节点放在数组里，对数组进行荷兰国旗排，排完后再连成链表，需要耗费额外空间
    public static Node listPartition1(Node head, int pivot){
        if(head==null) return head;
        Node cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        Node[] nodeArr = new Node[count];
        cur=head;
        for(int i=0;i<nodeArr.length;i++){
            nodeArr[i]=cur;
            cur=cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (int i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[nodeArr.length - 1].next = null;
        return nodeArr[0];
    }
    public static void arrPartition(Node[] nodeArr, int pivot){
        int less=-1,more=nodeArr.length,index=0;
        while(index!=more){
            if(nodeArr[index].value<pivot){
                swap(nodeArr,index++,++less);
            }else if(nodeArr[index].value==pivot){
                index++;
            }else {
                swap(nodeArr,index,--more);
            }
        }
    }
    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
    //不用耗费额外空间
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) { // 如果有小于区域
            sT.next = eH;
            eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
        }
        // 上面的if，不管跑了没有，et
        // all reconnect
        if (eT != null) { // 如果小于区域和等于区域，不是都没有
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        //head1 = listPartition1(head1, 2);
        head1 = listPartition2(head1, 2);
        printLinkedList(head1);

    }
}
