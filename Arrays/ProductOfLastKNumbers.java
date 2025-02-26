import java.util.*;
public class ProductOfLastKNumbers{
    //Approach-1 (Brute Force)
//T.C : add() - O(1), getProduct() - O(k)
//S.C : O(n) for the stream
    private  List<Integer>arr;
    private int n;
    public ProductOfLastKNumbers(){
        arr=new ArrayList<>();
        n=0;
    }
    public void  add(int num){
        arr.add(num);
    }
    int getProduct(int k){
        int prod=1;
        int n=arr.size();
        for(int i=n-k;i<n;i++){
            prod*=arr.get(i);
        }
        return prod;
    }
    //Approach-2 (Follow up optimal in O(1))
//T.C : O(1) for both methods
//S.C : O(n) for the stream
private List<Integer> nums; // cumulative prod store karenge

public void add1(int num) {
    if(num == 0) {
        nums.clear();
        n = 0;
    } else {
        if(nums.isEmpty()) {
            nums.add(num);
        } else {
            nums.add(nums.get(n-1) * num);
        }
        n++; // increasing size by 1
    }
}

public int getProduct1(int k) {
    if(k > n) {
        return 0;
    } else if(k == n) {
        return nums.get(n-1);
    }

    return nums.get(n-1) / nums.get(n-k-1);
}
}