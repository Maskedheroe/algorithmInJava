package com.example.hou.algorithminjava.interestingalgorithm.binarysearchpractice;

public class CutLine {
    public static void test(){

    }

    private static double solve(double[]nums,int k){
        double lowBound = 0.00, upBound = 10e5+0.01;
        while (lowBound+0.001<upBound){
            double mid = lowBound + (upBound - lowBound) / 2;
            if (isCut(nums, mid, k)) {
                lowBound = mid;
            } else {
                upBound = mid;
            }
        }

        return lowBound;
    }

    /**
     *
     * 二分搜索的 while 结束条件判定
     * 对于整型我们通常使用lb + 1 < ub, 但对于double型数据来说会有些精度上的丢失，使得结束条件不是那么好确定。
     * 像上题中采用的方法是题目中使用的精度除10。但有时候这种精度可能还是不够，
     * 如果结束条件lb + EPS < ub中使用的 EPS 过小时 double 型数据精度有可能不够从而导致死循环的产生！
     * 这时候我们将while循环体替换为for (int i = 0; i < 100; i++),
     * 100 次循环后可以达到 10−3010^{-30}10−30 精度范围，一般都没问题。
     *
     *
     * */


    private static boolean isCut(double[] nums, double seg, int k) {
        int count = 0;
        for (double num : nums) {
            count += Math.floor(num / seg);
        }
        return count >= k;
    }
}
