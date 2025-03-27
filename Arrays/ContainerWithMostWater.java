package Arrays;

/*
 * Using greedy two pointer[O(N)]
 */
public class ContainerWithMostWater {
    public int maxWater(int[] arr){
        int n=arr.length;
        int i=0;
        int j=n-1;
        int res=0;
        while(i<j){
            int water=Math.min(arr[i],arr[j])*(j-i);
            res=Math.max(res,water);
            if(arr[i]<arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }
}
