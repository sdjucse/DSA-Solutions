public class maxnestdepparent{
    public int maxDepth(String s){
        char[] chararr= s.toCharArray();
        int maxd=0;
        int stklen=0;
        for(char c : chararr){
            if(c=='('){
                stklen++;
            }
            else if(c==')'){
                stklen--;
            }
            if(stklen>maxd){
                maxd=stklen;
            }
        }
        return maxd;

    }
    public static void main(String args[]){
        maxnestdepparent m= new maxnestdepparent();
        String s="((())())";
        int res=m.maxDepth(s);
        System.out.println(res);
    }
}