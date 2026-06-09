
class Solution {
    int f(int i,int buy,int k,int[]p,int[][][]dp){
        if(k==0)return 0;//you cannot have more transcation if k=2 you can have only 2 transaction becoz in question they gave as atmost 2 transcation
        if(i>=p.length)return 0;
        if(dp[i][buy][k]!=-1)return dp[i][buy][k];
        int profit=0;
        if(buy==1){//for buy you have 2 option.buy on curr day or buy in future
            int bought=-p[i]+f(i+1,0,k,p,dp);
            int skip=0+f(i+1,1,k,p,dp);
            profit+=Math.max(skip,bought);
        }else{//eligible to sell
            int sell=p[i]+f(i+1,1,k-1,p,dp);
            int skip=0+f(i+1,0,k,p,dp);
            profit+=Math.max(skip,sell);
        }
        return dp[i][buy][k]=profit;
    }
    public int maxProfit(int k, int[] p) {
                 int n=p.length;
         int[][][]dp=new int[n][2][k+1];
         for(int[][] row : dp){
            for(int [] r:row){
                Arrays.fill(r,-1);
            }
         }
         int ans=f(0,1,k,p,dp);
         return ans;
    }
}