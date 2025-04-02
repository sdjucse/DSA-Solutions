public class NumberOf1Bits {
    //Approach-1 (Using simple bit magic)//
    public int hammingWeight(int n) {
        int cnt=0;
        for(int i=31;i>=0;i--){
            if(((n>>i)&1)==1){
                cnt++;
            }
        }
        return cnt;
    }
    //Approach-1 (Using simple bit magic)//
    public int hammingWeight2(int n) {
        int cnt=0;
        while(n!=0){
            cnt++;
            n=n&(n-1);
        }
        return cnt;
    }
}
