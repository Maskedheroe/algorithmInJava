package com.example.hou.algorithminjava;

/**
 * Created by hou on 2018/9/24.
 */

public class Example {

    public static void sort(Comparable[] a) {

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for (Comparable anA : a) {
            System.out.print(anA + "");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0,lenght = a.length; i < lenght; i++) {
            if (less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

}
