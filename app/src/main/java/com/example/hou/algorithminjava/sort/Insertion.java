package com.example.hou.algorithminjava.sort;

import com.example.hou.algorithminjava.Example;

/**
 * Created by hou on 2018/9/24.
 *
 *
 * 插入排序
 *
 * 概念 数组中 每个元素距离它最终位置都不远
 *     数组中 只有几个元素的位置不对
 *
 *     插入排序对着样的数据很有效  选择排序就不好
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
