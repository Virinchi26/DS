import java.util.*;

class doublyLinkedList {
    class Node {
        char data;
        Node next;
        Node prev;

        Node(char data) {
            this.next = null;
            this.prev = null;
            this.data = data;
        }
    }

    Node head;

    void insertAtFront(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertAtEnd(char data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = null;
        }
    }

    char deleteAtFront() {
        char x = 0;
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        } else {
            x = head.data;
            Node temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            return x;
        }
    }

    char deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            char x = temp.data;
            temp.prev.next = null;
            return x;
        }
    }

    public void insertAtLeft(char data, int position) {
        int c = 0;
        Node newNode = new Node(data);
        Node temp = head;
        while (c != position - 2) {
            c++;
            temp = temp.next;
        }
        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void insertAtRight(char data, int position) {
        int c = 0;
        Node newNode = new Node(data);
        Node temp = head;
        while (c != position - 1) {
            c++;
            temp = temp.next;
        }
        newNode.prev = temp;
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
    }
    public void deleteAtLeft(int position){
        int c=0;
        Node temp=head;
        while (c!=position-3) {
            c++;
            temp=temp.next;
        }
        temp.next.next.prev=temp;
        temp.next=temp.next.next;
    }
    public void deleteAtRight(int position){
        int c=0;
        Node temp=head;
        while (c!=position-1) {
            c++;
            temp=temp.next;
        }
        temp.next.next.prev=temp;
        temp.next=temp.next.next;
    }
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(" ");
    }
}

public class Exp4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i;
        char num;
        doublyLinkedList d = new doublyLinkedList();
        int flag = 0;
        while (true) {
            System.out.print(
                    "\n 1) Insert at front \n 2) Insert at End \n 3) Delete at front \n 4) Delete at End \n 5) Insert at Left \n 6) Insert at Right \n 7) Delete at left \n 8) Delete at Right");
            System.out.print("\n Enter the option you want: ");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the data to be inserted at the front: ");
                    char data = scan.next().charAt(0);
                    d.insertAtFront(data);
                    System.out.print("List: ");
                    d.display();
                    break;
                case 2:
                    System.out.print("Enter the data to be inserted at the end: ");
                    data = scan.next().charAt(0);
                    d.insertAtEnd(data);
                    System.out.print("List: ");
                    d.display();
                    break;
                case 3:
                    char x = d.deleteAtFront();
                    d.display();
                    break;
                case 4:
                    x = d.deleteAtEnd();
                    d.display();
                    break;
                case 5:
                    System.out.print("Enter data to be inserted at the left: ");
                    num = scan.next().charAt(0);
                    System.out.print("Enter the position: ");
                    i = scan.nextInt();
                    d.insertAtLeft(num, i);
                    d.display();
                    break;
                case 6:
                    System.out.print("Enter data to be inserted at the right: ");
                    num = scan.next().charAt(0);
                    System.out.print("Enter the position: ");
                    i = scan.nextInt();
                    d.insertAtRight(num, i);
                    d.display();
                    break;
                case 7:
                    System.out.print("Enter position: ");
                    i=scan.nextInt();
                    d.deleteAtLeft(i);
                    d.display();
                    break;    
                case 8:
                    System.out.print("Enter position: ");
                    i=scan.nextInt();
                    d.deleteAtRight(i);
                    d.display();
                    break;    
                default:
                    break;
            }
            System.out.print("\nEnter 1 to continue and 2 to exit: ");
            flag = scan.nextInt();
            if (flag == 2) {
                break;
            }
        }
    }
}