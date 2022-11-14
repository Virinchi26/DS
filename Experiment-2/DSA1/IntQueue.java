package DSA1;
public class IntQueue {
    int[] queue;
    int front;
    int rear;
    int capacity;

    public IntQueue(int size) {
        queue = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public void enqueue(int e) {
        if (isFullQueue()) {
            System.out.println("Queue is full!");
        }
        queue[++rear] = e;
    }

    public int dequeue() {
        if (isEmptyQueue()) {
            System.out.println("Queue is empty!");
        }
        return queue[front++];
    }

    public int front() {
        if (isEmptyQueue()) {
            System.out.println("Queue is empty!");
        }
        return queue[front];
    }

    public int rear() {
        if (isEmptyQueue()) {
            System.out.println("Queue is empty!");
        }
        return queue[rear];
    }

    public String printQueue() {
        String s = "[";
        for (int i = front; i < rear + 1; i++) {
            s += queue[i] + (i != rear ? "," : "");
        }
        return s += "]";
    }

    public boolean isEmptyQueue() {
        return front > rear;
    }

    public boolean isFullQueue() {
        return rear == capacity - 1;
    }

    public int size() {
        return rear + 1 - front;
    }
}