package week8to11;

public class queueExample {
    int q[];
    int front = -1;
    int rear = -1;
    int size;

    queueExample(int size) {
        this.size = size;
        q = new int[size];
    }

    public boolean enq(int data) {
        if (isFull()) {
            System.out.println("Queue OverFlow");
            return false;
        }
        if (rear == -1 && front == -1) {
            front = 0;
        }
        q[++rear] = data;
        return true;
    }

    public int deq() {
        if (isEmpty()) {
            System.out.println("Queue UnderFlow");
            return -10;
        }
        if (front == rear) {
            int x = rear;
            front = rear = -1;
            return q[x];
        }
        return q[front++];
    }

    public boolean isFull() {
        return rear == size - 1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public static void main(String[] args) {
        queueExample qe = new queueExample(3);
        qe.deq();
    }
}