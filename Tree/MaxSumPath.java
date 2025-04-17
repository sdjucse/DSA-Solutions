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

public class MaxSumPath {
     public int maxPathSum(Node root) {
       int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        computeSum(root, maxValue);
        return maxValue[0];
    }
    public int computeSum(Node root,int maxi[]){
        if(root==null){
            return 0;
        }
        int leftmaxPath=Math.max(0,computeSum(root.left,maxi));
        int rightmaxPath=Math.max(0,computeSum(root.right,maxi));
        maxi[0] = Math.max(maxi[0], leftmaxPath + rightmaxPath + root.data);
        return root.data + Math.max(leftmaxPath,rightmaxPath);
    }
}
