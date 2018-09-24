package com.example.hou.algorithminjava.sort;

import com.example.hou.algorithminjava.Example;

/**
 * Created by hou on 2018/9/24.
 */

public class Insertion {

    public static void sort(Comparable[] a){
        //将a[]升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //将a[i]插入到a[i-1], a[i-2], a[i-3]之中
            for (int j=i;j>0 && Example.less(a[j],a[j-1]);j--){
                //每次都是对a[j]进行排序
                Example.exch(a,j,j-1);
            }
        }
    }

}
