public class StackUsingLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

    }
    Node top;
    int n;
    StackUsingLinkedList(){
        this.top=null;
        this.n=0;
    }
    public void push(int data){
        Node newNode= new Node(data);
        newNode.next=top;
        top=newNode;
        n++;

    }
    public int pop(){
        if(top==null){
            System.out.println("Stack is empty");
            return -1;
        }
        int topData=top.data;
        Node temp=top;
        top=top.next;
        return topData;

    }
    public int peek(){
        if(top==null){
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n==0;
    }
    public void printStack(){
        Node temp=top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

