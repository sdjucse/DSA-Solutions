import java.util.ArrayList;

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
public class PreOrderTraversal{
    public ArrayList<Integer>PreOrderTraversal(Node root){
        ArrayList<Integer>arr=new ArrayList<>();
        if(root==null){
            return arr;
        }
        arr.add(root.data);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
        
    }
}