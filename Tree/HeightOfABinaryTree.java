class Node{
    int data;
    Node left;
    Node right;

    Node(){

    }
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    Node(int data,Node left,Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }
}

public class HeightOfABinaryTree {
    public int BinaryTreeHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=BinaryTreeHeight(root.left);
        int right=BinaryTreeHeight(root.right);
        return Math.max(left,right)+1;
    }
}
