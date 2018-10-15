package com.example.hou.algorithminjava.practice;


//考拉兹猜想
public class Kolazi {

    public static void test(){
        for (int i = 2; i < 1000; i++) {
            if (calcaulator(i,1))
                System.out.println(i+"是考拉次数!");
        }
    }

    private static boolean calcaulator(int n,int flag){

        if (n%2==1){
            n*=3+1;
        }else {
            flag++;
            if (flag>1){
                n/=2;
            }else {
                n*=3+1;
            }
        }

        if (n==1){
            return false;
        }else {
            calcaulator(n,flag);
        }
        return true;
    }

}
