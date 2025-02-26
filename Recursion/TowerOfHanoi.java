



public class TowerOfHanoi{
    public long toh(int n, int a, int c, int b) {
        long temp=0;
        // Your code here
        if(n==1){
            System.out.println("move disk 1 from rod "+a+" to rod "+c);
            return 1;
        }
        temp=temp + toh(n-1,a,b,c);
         System.out.println("move disk "+n+" from rod "+a+" to rod "+c);
         temp++;
        temp=temp + toh(n-1,b,c,a); 
        return temp;
        
    }
}


// User function Template for Java


// avoid space at the starting of the string in "move disk....."



