class Node{
    int data;
    Node left;
    Node right;

    Node(){

    }
    Node(int data){
        this.data=data;
    }
    Node(int data,  Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
public class InvertBinaryTree {
    public Node invertBinaryTree(Node root){
        if(root==null){
            return null;
        }
        Node left=root.left;
        Node right=root.right;
        root.left=right;
        root.right=left;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return root;
    }
}
