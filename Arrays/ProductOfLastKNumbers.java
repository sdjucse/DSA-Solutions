import java.util.*;
public class ProductOfLastKNumbers{
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
}