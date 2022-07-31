package week8to11;

public class stack0 {
    int[] stack1;
    int top = -1;
    int size;

    stack0(int size) {
        this.size = size;
        stack1 = new int[size];
    }

    public boolean push(int data) {
        if (isFull()) {
            System.out.println("StackOverFlow");
            return false;
        }
        // top++;
        stack1[++top] = data;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
            return -0101;
        }
        int x = top;
        top--;
        return stack1[x];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Empty Stack");
            return 0;
        }
        return stack1[top];
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
