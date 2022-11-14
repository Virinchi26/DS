package DSA;

public class intSTACK {
    int stack[];
    int size;
    int top;

    public intSTACK() {
        size = 100;
        top = -1;
        stack = new int[size];
    }

    public void push(int n) {
        if (!isFull()) {
            stack[++top] = n;
            System.out.println(n + " has been pushed.");
        } else {
            System.out.println("STACK OVERFLOW.");
        }
    }

    public void pop() {
        if (!isEmpty()) {
            System.out.println(peek() + " has been popped.");
            top--;
        } else {
            System.out.println("STACK UNDERFLOW.");
        }
    }

    public int peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }
}