public class ReverseBits {
    public int reverseBits_UsingBitManipulation(int n) {
       int res=0;
       for(int i=0;i<32;i++){
              int lsb=n&1;
              int revereselsb=lsb<<(31-i);
              res=res|revereselsb;
              n=n>>1;
       }
       

       return res;
    }
}
