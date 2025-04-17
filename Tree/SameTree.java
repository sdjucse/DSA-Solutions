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
public class SameTree {
    public boolean isSameTree(Node p,Node q){
        if(p==null && q==null){
            return true;
        }
        else if(p==null || q==null){
            return false;
        }
        else{
            return ((p.data==q.data)&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right));
        }
    }
}
