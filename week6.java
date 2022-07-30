class Node {
    public int  data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void print() {
        System.out.print(this.data);
    }
}

class LinkedList {
    public Node head;
    private Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    LinkedList(int arr[]) {
        this.head = new Node(arr[0]);
        this.tail = this.head;

        for (int i = 1; i < arr.length; i ++) {
            this.tail.next = new Node(arr[i]);
            this.tail = this.tail.next;
        }
    }

    public void sortAndMergeWith(LinkedList l) {
        Node n1 = l.head;

        if (this.head == null) {
            this.head = new Node(l.head.data);
            this.tail = this.head;
            n1 = n1.next;
        }

        for (; n1 != null; n1 = n1.next) {
            if (n1.data < this.head.data) {
                Node tmp = this.head;
                this.head = new Node(n1.data);
                this.head.next = tmp;
                continue;
            }

            for (Node n2 = this.head; n2 != null; n2 = n2.next) {
                if (n2.next == null) {
                    n2.next = new Node(n1.data);
                    break;
                }

                if (n1.data < n2.next.data) {
                    Node tmp = n2.next;
                    n2.next  = new Node(n1.data);
                    n2.next.next = tmp;
                    break;
                }
            }
        }
    }

    public void print() {
        for (Node node = this.head; node != null; node = node.next) {
            node.print();
            System.out.print(node + " ");
        }
    }
}

class Main {
    static LinkedList sortAndMergeKLists(LinkedList arr[]) {
        LinkedList ret = new LinkedList();

        for (int i = 0; i < arr.length; i ++)
            ret.sortAndMergeWith(arr[i]);

        return ret;
    }

    // public static double findMedian(int arr[]){
    //     LinkedList d = sortAndMergeKLists(a);
    //     // check for even case
    //     if (n % 2 != 0)
    //         return (double)a[n / 2];
 
    //     return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    // }

    public static void main(String[] args) {
        LinkedList[] a = {
            new LinkedList(new int[] {9, 2, 7}),
            new LinkedList(new int[] {3, 4, 5}),
            new LinkedList(new int[] {8, 1, 6}),
        };
        LinkedList d = sortAndMergeKLists(a);
        d.print();
    }
}
