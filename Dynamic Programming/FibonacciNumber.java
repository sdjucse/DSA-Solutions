public class FibonacciNumber {
    //Using Memoization & Recursion//
    public int solve(int n,int[]dp){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }
    public int fibo_usingrecusrion(int n){
        if(n<=1){
            return n;
        }
        int []dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = -1; // Initialize the dp array with -1
        }
        return solve(n,dp);
    }



    //Using Tabulation//
    public int fibo_usingtabulation(int n){
        int [] dp = new int[n+1];
        dp[0] = 0; // Base case
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2]; // Fill the dp array iteratively
        }
        return dp[n];
    }
    //Using Space Optimization//

    public int fibo_usingspaceoptimization(int n){
        if(n<=1){
            return n;
        }
        int c=0;
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            c = a + b; // Calculate the next Fibonacci number
            a = b; // Update a to the previous b
            b = c; // Update b to the current Fibonacci number
        }
        return c;
    }
    
}
