package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class FindUnion {
    static ArrayList<Integer>FindUnion(int arr1[],int arr2[],int n,int m){
        HashSet<Integer>set=new HashSet<>();
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<m;i++){
            set.add(arr2[i]);
        }
        for(int i:set){
            list.add(i);
        }
        return list;
    }
}
