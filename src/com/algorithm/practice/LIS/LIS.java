package com.algorithm.practice.LIS;

import java.util.prefs.Preferences;

/**
 * Created by zhaorenming on 2015/9/14.
 */
public class LIS {

    public static void main(String[] args) {
        int[] seq = {3, 8, 2, 9, 6, 7, 8, 1};
        int[] maxLen = new int[seq.length];

        for(int i=0; i<seq.length; i++) {
            maxLen[i] = 0;
        }
        maxLen[1] = 1;

        for(int i=0; i<seq.length; i++) {   //以第i个数字为结尾的LIS
//            for(int j=0; j<i; j++) {
//                if(seq[i]>seq[j] && maxLen[i]<maxLen[j]+1) {
//                    maxLen[i] = maxLen[j]+1;
//                }
//            }
        }

        System.out.println("result:" + maxLen);


    }

}
