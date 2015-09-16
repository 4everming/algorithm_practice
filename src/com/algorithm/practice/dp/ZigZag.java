package com.algorithm.practice.dp;

/**
 * Created by zhaorenming on 2015/9/15.
 */
class Node {
    public int cnt = 1;             //ZigZag序列的第几个
    public boolean isPositive;
}


public class ZigZag {

    public static void main(String[] args) {
        int[] seq = { 1, 7, 4, 9, 2, 5 };
        Node[] dp = new Node[seq.length];

        if (seq.length<=2) {
            System.out.println("This is a ZigZag sequence. The max length is: " + seq.length );
            return;
        }

        Node n = new Node();
        if (seq[1]-seq[0]>0) {
            n.isPositive = true;
            n.cnt = 2;
        }
        else {
            n.isPositive = false;
            n.cnt = 2;
        }
        dp[0] = n;

        //初始化dp[]
        for (int i = 1; i<seq.length; i++) {
            Node node = new Node();
            node.cnt = 1;
            dp[i] = node;
        }


        for (int rear=2; rear<seq.length; rear++) {
            if ( (seq[rear] - seq[rear-1]>0 && !dp[rear-1].isPositive) ) {
                dp[rear].cnt = dp[rear-1].cnt + 1;
                dp[rear].isPositive = true;
            }
            else if (seq[rear] - seq[rear-1]<0 && dp[rear-1].isPositive) {
                dp[rear].cnt = dp[rear-1].cnt + 1;
                dp[rear].isPositive = false;
            }
            else {
                dp[rear].isPositive = seq[rear] - seq[rear-1]>0;
            }
        }

        return ;
    }
}
