import java.util.HashMap;

public class CountLargestGroups {
   private int findDigitsSum(int x){
        int sum=0;
        while(x>0){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }
    public int CountLargestGroups(int n)
    {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int cnt=0;
        int maxSize=0;
        for(int i=1;i<=n;i++){
            int digitSum=findDigitsSum(i);
            mp.put(digitSum,mp.getOrDefault(digitSum,0)+1);
            int groupSize=mp.get(digitSum);
            if(groupSize==maxSize){
                cnt++;
            }
            else if (groupSize>maxSize) {
                maxSize=groupSize;
                cnt=1;
            }
        }


        return cnt;
}
}
