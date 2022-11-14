import java.util.*;


import static java.lang.Math.max;
class AVL {
    Node start;

    private class Node {
        int item;
        Node left;
        Node right;
        int height;

        Node(int item) {
            this.item = item;
            this.height = 1;
        }
    }

    Node root;

    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.item + " ");
        inOrder(root.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = updateHeight(y);
        x.height = updateHeight(x);
        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = updateHeight(x);
        y.height = updateHeight(y);
        return y;
    }

    Node LR(Node root) {
        if (root == null) {
            return null;
        }
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    Node RL(Node root) {
        if (root == null) {
            return null;
        }
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    int updateHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height = 1 + max(height(root.left), height(root.right));
    }

    Node creation(Node node, int item) {

        // Find the position and insert the node
        if (node == null) {
            Node temp = new Node(item);
            return temp;
        }
        if (item < node.item) {
            node.left = creation(node.left, item);
        } else if (item > node.item) {
            node.right = creation(node.right, item);
        } else {
            return node;
        }

        node.height = updateHeight(node);
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (item < node.left.item) {
                return rightRotate(node);
            } else if (item > node.left.item) {
                return LR(node);
            }
        }
        if (balanceFactor < -1) {
            if (item > node.right.item) {
                return leftRotate(node);
            } else if (item < node.right.item) {
                return RL(node);
            }
        }
        return node;
    }
}
public class tp2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVL a = new AVL();
        System.out.println("Enter number of elements you want to insert");
        int elements = sc.nextInt();
        for (int i = 0; i < elements; i++) {
            System.out.println("Enter key to add:");
            int key = sc.nextInt();
            a.start = a.creation(a.start, key);
            System.out.println("AVL tree status:");
            a.inOrder(a.start);
            System.out.println();
        }
        System.out.println("Created AVL tree:");
        a.inOrder(a.start);
        System.out.println();
}
}