package com.example.hou.algorithminjava.interestingalgorithm;

public class Gcd {

    public int gcd(int a, int b) {    //循环实现
        int k = 0;
        do {
            //得到余数
            k = a % b;
            //根据辗转相除法,把被除数赋给除数
            a = b;
            //余数赋给被除数
            b = k;
        } while (k != 0);
        //返回被除数
        return a;
    }

    //逆归实现
    public int gcd2(int a,int b) {
        //直到满足此条件逆归退出
        if(b == 0) {
            return a;
        }
        if(a < 0) {
            return gcd2(-a,b);
        }
        if(b < 0) {
            return gcd2(a,-b);
        }
        return gcd2(b,a % b);
    }

}
