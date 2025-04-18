public class CountTheNumberOfPowerfulIntegers {
    private long solve(String str,String suffix,int limit){
        if(str.length()<suffix.length()){
            return 0;
        }

    } 
    public long CountTheNumberOfPowerfulIntegers(long start,long end,int limit,String s){
        String startStr=String.valueOf(start-1);
        String endStr=String.valueOf(end);
        return solve(endStr,s,limit)-solve(startStr,s,limit); 
    }
}
