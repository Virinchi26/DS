import java.util.*;

class Node {
    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }
}

class Exptree {
    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
            return true;
        return false;
    }

    Node expressiontree(String s) {
        stack sa = new stack(s.length());
        int operator = 0;
        int operand = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!isOperator(s.charAt(i))) {
                operand++;
            } else {
                operator++;
            }
        }
        if (operand != operator + 1) {
            System.out.print("Invalid");
            System.exit(0);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!isOperator(s.charAt(i))) {
                Node temp = new Node(s.charAt(i));
                sa.push(temp);
            } else {
                Node t1 = sa.pop();
                Node t2 = sa.pop();
                Node temp = new Node(s.charAt(i));
                temp.left = t2;
                temp.right = t1;
                sa.push(temp);
            }
        }
        Node root = sa.pop();
        return root;
    }

    void Inorder(Node root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print("" + root.data + "");
            Inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print("" + root.data + "");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print("" + root.data + "");
        }
    }
}

class stack {
    Node stack[];
    int top, maxsize;

    stack(int x) {
        maxsize = x;
        stack = new Node[maxsize];
        top = -1;
    }

    void push(Node p) {
        stack[++top] = p;
    }

    Node pop() {
        if (top == -1)
            return null;
        return stack[top--];
    }
}
class Exp6 {
    public static void main(String[] args) {
        Exptree t = new Exptree();
        Node root;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Postfix equation : ");
        String s = sc.nextLine();
        root = t.expressiontree(s);
        int flag=1;
        while (flag==1) {
            System.out.print("1) Inorder \n2) Preorder \n3) Postorder\n");
            System.out.print("Enter the option you want: ");
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                System.out.print("Inorder : ");
                t.Inorder(root);
                    break;
                case 2:
                System.out.print("Preorder : ");
                t.preorder(root);
                    break;
                case 3:
                System.out.print("Postorder : ");
                t.postorder(root);
                    break;
            
                default:
                    break;
            }
            System.out.print("\nPress 1 to continue and 0 to exit ");
            flag=sc.nextInt();
            if (flag==0) {
                break;
            }
        }
        sc.close();
    }
}