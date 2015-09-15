package com.algorithm.practice.LIS;

/**
 * Created by zhaorenming on 2015/9/14.
 */
public class Conis {
    //中文test

    public static void main(String[] args) {
        int[] coinType = {1, 3, 5}; //coin value 1, 3, 5
        int total = 11;  //total money

        int[] dp = new int[coinType.length+1];

        //initial dp[] to max value
        for (int i=0;i<total;i++) {
            dp[i] = 999;
        }
        //0 way to get 0 money
        dp[0] = 0;

        for (int i=1;i<=total;i++) {
            //dp(i) = min{d(i-Vj)+1}, i-Vj>=0
            //minTemp   min{d(i-Vj)+1}
            int minTemp = 999;

            for (int type=0;type<coinType.length;type++) {
                int nowCoinVal = coinType[type];
                if(i>=nowCoinVal && i-nowCoinVal>=0 && minTemp>dp[ i-nowCoinVal ]) {
                    minTemp = dp[ i-nowCoinVal ] + 1;
                }
            }
            dp[i] = minTemp;
        }
        System.out.println("The dp count is: " + dp[dp.length-1]);

        return ;
    }

}
