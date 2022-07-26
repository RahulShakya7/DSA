class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Mergelists{
    static Node head = null;
    Node tail = null;

    static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node mergekList(Node arr[], int last){
        for ( int i = 1; i <= last; i++){
            while(true){
                Node head_1 = arr[0];
                Node head_2 = arr[i];

                if (head_2 == null){
                    break;
                }

                if (head_1.data >= head_2.data){
                    arr[i] = head_2.next;
                    head_2.next = head_1;
                    arr[0] = head_2;
                } else {
                    while (head_1.next != null){
                        if(head_1.next.data >= head_2.data){
                            arr[i] = head_2.next;
                            head_2.next = head_1.next;
                            head_1.next = head_2;
                            break;
                        }

                        head_1 = head_1.next;

                        if (head_1.next == null){
                            arr[i] = head_2.next;
                            head_2.next = null;
                            head_1.next = head_2;
                            head_1.next.next = null;
                            break;
                        }
                    } 
                }
            }
        }
        return arr[0];
    }
    // static void merge(){

    // }
    // static void median(int head){
    //     int median = mergekList(arr, k - 1).getSize() / 2; 
    //     System.out.println("Median: " + mergekList(arr, k - 1).getDataAtAnyPos(median)); 
    // }

    public static void main(String[] args) {
        int k =4;

        Node[] arr = new Node[k];

        arr[0] = new Node(2);
        arr[0].next = new Node(4);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        arr[0].next.next.next.next = new Node(10);

        arr[1] = new Node(3);
        arr[1].next = new Node(2);
        arr[1].next.next = new Node(7);
        arr[1].next.next.next = new Node(9);

        arr[2] = new Node(12);
        arr[2].next = new Node(5);
        arr[2].next.next = new Node(6);
        arr[2].next.next.next = new Node(9);

        // Merge all lists
        head = Mergelists.mergekList(arr, k - 1);
        printList(head);

    }
}
    
    
    


        