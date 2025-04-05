package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class FindUnion {
    /*
     * Time Complexity: O((N+M)log(M+N)) where N is the length of arr1 and M is the length of arr2.
     * Space Complexity: O(N+M) for the HashSet and ArrayList.
     */
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
    /*
     * Approach-2: Using Two Pointers
     * Time Complexity: O(N+M) where N is the length of arr1 and M is the length of arr2.
     *  Space Complexity: O(N+M) for the two pointers.
     */
    static ArrayList<Integer> FindUnion2(int arr1[],int arr2[],int n,int m){
         ArrayList<Integer>list=new ArrayList<>();
         int i=0,j=0;
            while(i<n && j<m){
                if(arr1[i]<arr2[j]){
                    if(list.size()==0 || list.get(list.size()-1)!=arr1[i]){
                        list.add(arr1[i]);
                    }
                    i++;
                }else if(arr1[i]>arr2[j]){
                    if(list.size()==0 || list.get(list.size()-1)!=arr2[j]){
                        list.add(arr2[j]);
                    }
                    j++;
                }else{
                    if(list.size()==0 || list.get(list.size()-1)!=arr1[i]){
                        list.add(arr1[i]);
                    }
                    i++;
                    j++;
                }
            }
            return list;
        }
    }

