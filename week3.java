import java.util.*;

class week3{

    class MergeLists {
        Node head; 
        
        /* Method to insert a node at 
        the end of the linked list */
        public void addToTheLast(Node node){
            if (head == null)
            {
                head = node;
            }
            else 
            {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }
        
        /* Method to print linked list */
        void printList(){
            Node temp = head;
            while (temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } 
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> list3 = new LinkedList<Integer>();
    
    }
}