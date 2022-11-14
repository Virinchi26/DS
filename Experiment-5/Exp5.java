import java.util.*;

class BST {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    void insert(int data) {
        root = insert(root, data);
    }

    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        } else if (data >= root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;
    }

    void delete(int data) {
        root = delete(root, data);
    }

    Node delete(Node root, int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    void inorder() {
        inorder(root);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder() {
        preorder(root);
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder() {
        postorder(root);
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class Exp5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST obj = new BST();
        int choice, flag = 1;
        while (flag == 1) {
            System.out.println("\n 1) Insert \n 2) Delete \n 3) Inorder \n 4) Preoder \n 5) Postorder\n ");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be inserted: ");
                    obj.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter the element to be deleted: ");
                    obj.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Inorder: ");
                    obj.inorder();
                    break;
                case 4:
                    System.out.print("Preorder: ");
                    obj.preorder();
                    break;
                case 5:
                    System.out.print("Postorder: ");
                    obj.postorder();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("\nEnter 1 to continue and 0 to exit: ");
            flag = sc.nextInt();
            if (flag == 0) {
                break;
            }

        }
    }
}