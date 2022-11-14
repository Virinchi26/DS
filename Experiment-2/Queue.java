import java.util.*;

import DSA1.*;
class Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int n = sc.nextInt();
        IntQueue queue = new IntQueue(n);
        int flag,choice;
        while(true) {
            System.out.println("Select an Operation:\n 1) Enqueue\n 2) Dequeue\n 3) Front\n 4) Rear \n 5) Size");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter the element to be enqueued: ");
                    int e = sc.nextInt();
                    try {
                        queue.enqueue(e);
                        System.out.println("Queue: " + queue.printQueue());
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Dequeued element: " + queue.dequeue());
                        System.out.println("Queue: " + queue.printQueue());
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Front element: " + queue.front());
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Rear element: " + queue.rear());
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Size: " + queue.size());
                    System.out.println("Queue: " + queue.printQueue());
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println("Press 1 to continue or 0 to exit");
            flag = sc.nextInt();
            if (flag == 0) {
                break;
            }
        }
        sc.close();
    }
}