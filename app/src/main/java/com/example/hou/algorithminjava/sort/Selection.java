package com.example.hou.algorithminjava.sort;

import com.example.hou.algorithminjava.Example;

/*
*
* 选择排序
* 运行时间和输入无关 你会发现 一个有序或一样元素的数据 和一个随机的数据排序时间一样
*
* 数据移动最少 线性级别
* */

public class Selection {

    public static void sort(Comparable[] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            //将a[i] 和 a[i+1..n]中 的最小元素交换
            int min =i;
            for (int j = i+1;j<n;j++){
                if (Example.less(a[j],a[min])){
                    min = j;
                }
            }
            Example.exch(a,i,min);
        }
    }

}
