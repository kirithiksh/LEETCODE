class Solution {
        int f(int i,int buy,int fee,int []p,int [][]dp){
            if(i>=p.length)return 0;
            if(dp[i][buy]!=-1) return dp[i][buy];
            int profit=0;
            if(buy==1){//youu are eligible to buy
                int bought=-p[i]+f(i+1,0,fee,p,dp);//buy on this day
                int skip=0+f(i+1,1,fee,p,dp);//skip this day but buy in future
                profit+=Math.max(bought,skip);
            }else{//eligible to sell
                int sell=(p[i]-fee)+f(i+1,1,fee,p,dp);//sell on this day
                int skip=0+f(i+1,0,fee,p,dp);//sell in future
                profit+=Math.max(sell,skip);
            }
            return dp[i][buy]=profit;
        }
        public int maxProfit(int[] p,int fee) {
            int n=p.length;
            int [][] dp=new int [n][2];
            for(int []row : dp){
                Arrays.fill(row,-1);
            }int ans=f(0,1,fee,p,dp);
            return ans;
    }
}
