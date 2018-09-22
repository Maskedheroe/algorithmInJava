package com.example.hou.algorithminjava;

/**
 * Created by hou on 2018/9/22.
 */

public class RunOnTheStairs {
    private static final int STEPS = 4;

    public static int run(int a,int b){
        if (a>b) {
            return 0;
        }
        if (a==b){
            return 1;
        }
        int current = 0;
        for (int i = 0; i < STEPS; i++) {
            for (int j = 0; j < STEPS; j++) {
                current += run(a+i,b-j);
            }
        }
        return current;
    }
}
