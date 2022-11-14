import java.util.Scanner;

class AvlTree {
    class Node {
        int data;
        Node left,right;
        int height;
        Node(int data) {
            this.data = data;
            left = right = null;
            height = 1;
        }
    }
    public Node root=null;
    public int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }
    public Node SingleLL(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }
    public Node SingleRR(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }
    public Node DoubleLR(Node root) {
        root.left = SingleRR(root.left);
        return SingleLL(root);
    }
    public Node DoubleRL(Node root) {
        root.right = SingleLL(root.right);
        return SingleRR(root);
    }
    public int getBF(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }
    public void insert(int data) {
        root = inserter(root, data);
    }
    public Node inserter(Node root,int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = inserter(root.left, data);
        } else if (data > root.data) {
            root.right = inserter(root.right, data);
        } else {
            return root;
        }
        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bal = getBF(root);
        if (bal>1 && data<root.left.data) {
            System.out.println("LL Rotation performed");
            return SingleLL(root);
        }
        if (bal<-1 && data>root.right.data) {
            System.out.println("RR Rotation performed");
            return SingleRR(root);
        }
        if (bal>1 && data>root.left.data) {
            System.out.println("LR Rotation performed");
            return DoubleLR(root);
        }
        if (bal<-1 && data<root.right.data) {
            System.out.println("RL Rotation performed");
            return DoubleRL(root);
        }
        return root;
    }
    /* Deletion Code    
 public void delete(Node root,int data) {
        root = deleter(root, data);
    }
    public Node deleter(Node root,int data) {
        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleter(root.left, data);
        } else if (data > root.data) {
            root.right = deleter(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleter(root.right, root.data);
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bal = getBF(root);
        if (bal>1 && getBF(root.left)>=0) {
            return SingleLL(root);
        }
        if (bal>1 && getBF(root.left)<0) {
            return DoubleLR(root);
        }
        if (bal<-1 && getBF(root.right)<=0) {
            return SingleRR(root);
        }
        if (bal<-1 && getBF(root.right)>0) {
            return DoubleRL(root);
        }
        return root;
    }
    public int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
    public int size(Node root) {
        if (root == null)
            return 0;
        else
            return (size(root.left) + 1 + size(root.right));
    }
    */
    public void PreOrder(Node root) {
        if (root!=null) {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    public void InOrder(Node root) {
        if (root!=null) {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }
    public void PostOrder(Node root) {
        if (root!=null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class AVLCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AvlTree avl = new AvlTree();
        int choice,flag;
        int n,d;
        while(true) {
            System.out.println("\n1. Insert\n2. PreOrder\n3. InOrder\n4. PostOrder");
            System.out.print("Select an option: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter no. of elements to insert: ");
                    n = sc.nextInt();
                    System.out.print("Enter the elements: ");
                    for (int i = 0; i < n; i++) {
                        avl.insert(sc.nextInt());
                        avl.PreOrder(avl.root);
                        System.out.println();
                    }
                    break;
                /*case 2:
                    /*System.out.print("Enter the element to delete: ");
                    d = sc.nextInt();
                    avl.delete(avl.root,d);
                    System.out.print("InOrder: ");
                    avl.InOrder(avl.root);
                    System.out.println();
                    break;
                    */
                case 2:
                    System.out.print("PreOrder: ");
                    avl.PreOrder(avl.root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("InOrder: ");
                    avl.InOrder(avl.root);
                    System.out.println();
                    break;
                case 4:    
                    System.out.print("PostOrder: ");
                    avl.PostOrder(avl.root);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            System.out.println("Do you want to continue?\n1. Yes\t0. No");
            flag = sc.nextInt();
            if (flag == 0) {
                break;
            }
        }
        sc.close();
    }    
}