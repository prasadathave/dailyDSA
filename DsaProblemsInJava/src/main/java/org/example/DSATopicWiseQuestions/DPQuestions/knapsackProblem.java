package org.example.DSATopicWiseQuestions.DPQuestions;

public class knapsackProblem {
    public static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int[][] dp = new int[val.length][capacity+1];
        for(int cp=1; cp<capacity+1; cp++){
            for(int sz =0; sz< val.length; sz++){

                if(sz>0){
                    dp[sz][cp] = Math.max(dp[sz][cp],dp[sz-1][cp]);
                }
                if(cp-wt[sz]>=0 && sz>0){
                    dp[sz][cp] = Math.max(dp[sz][cp],dp[sz-1][cp-wt[sz]]+val[sz]);
                }
                if(sz==0 && cp-wt[sz]>0){
                    dp[sz][cp] = Math.max(dp[sz][cp],val[sz]);
                }
            }
        }


        return dp[val.length-1][capacity];
    }
    public static int knapSackgfg(int W,  int[] val,int[] wt) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }


}
