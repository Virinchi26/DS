import java.util.*;

class AVL{
    class Node{
        int key, height;
        Node left, right;
        Node(int d){
            key = d;
            height = 1;
        }
    }
    Node root;
    int height(Node N){
        if (N == null)
            return 0;
        return N.height;
    }
    int max(int a, int b){
       
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    Node LL(Node a){
        Node b = a.left;
        Node c = b.left;
        if(b.right == null){
            b.right = a;
            a.left = null;
        }
        else{
            a.left = b.right;
            b.right = a;
        }
        System.out.print("LL rotation\n");
        c.height = max(height(c.left), height(c.right)) + 1;
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;
        return b;
    }
    Node RR(Node a){
        Node b = a.right;
        Node c = b.right;
        if(b.left == null){
            b.left = a;
            a.left = null;
        }
        else{
            b.left=a.right ;
            b.left= a;
        }
        System.out.print("RR rotation\n");
        c.height = max(height(c.left), height(c.right)) + 1;
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;
        return b;
    }
    Node LR(Node a){
        Node b = a.left;
        Node c = b.right;
        if(c.right == null){
            c.right = a;
            a.left=null;
        }
        else{
            a.left = c.right;
            c.right = a;
        }
        if(c.left == null){
            c.left = b;
            b.right=null;
        }
        else{
            b.right = c.left;
            c.left = b;
        }
        System.out.print("LR rotation\n");
        a.height = max(height(a.left), height(a.right)) + 1;
        b.height = max(height(b.left), height(b.right)) + 1;
        c.height = max(height(c.left), height(c.right)) + 1;
        return c;
    }
    int getBalance(Node N){
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    void insert(int key){
        root = insert(root, key);
    }
    Node insert(Node node, int key){
        if (node == null)
            return (new Node(key));
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;
        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && key < node.left.key)
            return LL(node);
        if (balance < -1 && key > node.right.key)
            return RR(node);
        if (balance > 1 && key > node.left.key){
            return LR(node);
        }
        return node;
    }
    void inorder(){
        inorder(root);
    }

    void inorder(Node node){
        if (node != null){
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    void preorder(Node root){
            if(root==null){
                System.out.println("");
            }
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
        }
    void preorder(){
        preorder(root);
    }
        void postorder(Node root){
            if(root==null){
                System.out.println("");
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+" ");
        }
        void postorder(){
        postorder(root);
    }
}


class AVLCheck{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AVL tree = new AVL();
        System.out.print("Enter number of nodes in AVL Tree: ");
        int n = sc.nextInt();
        System.out.print("Enter the no.'s: ");
        for(int i = 0; i < n; i++){
            tree.insert(sc.nextInt());
        }
        int flag=1,choice;
        while(flag==1){
        System.out.print("1) Inorder\n2) Preorder\n3) Postorder");
        System.out.print("\nEnter the option you want: ");
        choice=sc.nextInt();
        switch(choice){
        case 1:
        System.out.print("Inorder: ");
        tree.inorder();
        break;
        case 2:
        System.out.print("Preorder: ");
        tree.preorder();
        break;
        case 3:
        System.out.print("Postorder: ");
        tree.postorder();
        break;
        default:
        System.out.print("Invalid choice");
        break;
        }
        System.out.print("\nPress 1 to continue and 0 to exit: ");
        flag=sc.nextInt();
        if(flag==0){
        break;
        }
     }  
     sc.close();
   }
}
