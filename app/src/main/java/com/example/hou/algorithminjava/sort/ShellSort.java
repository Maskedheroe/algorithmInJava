package com.example.hou.algorithminjava.sort;


import com.example.hou.algorithminjava.Example;

/*
 *
 * 希尔排序
 * */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h<N/3){
            h = 3*h +1;
        }
        while (h>= 1){
            for (int i = h; i < N; i++) {
                for (int j=i;j>=h&&Example.less(a[j],a[j-h]);j-=h){
                    Example.exch(a,j,j-h);
                }
            }
            h /=3;
        }
    }

}
