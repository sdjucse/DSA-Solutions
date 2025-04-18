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

public class SubtreeOfAnotherTree {
    boolean isIdentical(Node root1,Node root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        return ((root1.data==root2.data)&&isIdentical(root1.left, root2.left)&&isIdentical(root1.right, root2.right));
    }
    boolean isSubTree(Node root,Node sub){
        if(root==null){
            return false;
        }
        if(sub==null){
            return true;
        }
        if(isIdentical(sub, root)){
            return true;
        }
        return isSubTree(root.left, sub)||isSubTree(root.right, sub);
    }

}
