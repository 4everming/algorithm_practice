package com.algorithm.practice.dp;

/**
 * Created by zhaorenming on 2015/9/14.
 */
public class LIS {

    public static void main(String[] args) {
        int[] seq = {3, 2, 4, 1, 5, 6, 9, 8};
        int[] dp = new int[seq.length+1];  //存以第i个数为终点的最长上升序列

        for(int i=0; i<seq.length; i++) {
            dp[i] = 1;
        }

        for(int rear=1; rear<seq.length; rear++) {
            for(int front=0; front<rear; front++) {
                if(seq[rear]>seq[front] && dp[front]+1>dp[rear]) {
                    dp[rear] = dp[front]+1;
                }
            }
        }

        //找到dp[]中最大的
        int max = 0;
        for (int i=0; i<dp.length; i++) {
            if(dp[i]>max) {
                max = dp[i];
            }
        }

        System.out.println("result:" + max);


    }

}
