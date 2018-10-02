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

}
