package com.example.hou.algorithminjava.practice;

/*
 *
 * 轮盘小题
 *
 * 注意 若要在数组上移动时  需要注意 边界问题
 * 假如一个圆形轮盘用数组来存储它时 超出最右端时从最左端读取
 * 这样可用蠕虫方式 每次下表从左向右移动步长后(总数加上一个数) 总数减去左端一个数   这样可以优化性能
 *
 *
 *
 * */

import com.example.hou.algorithminjava.Example;

public class Roulette {

    private static final int[] european = {0, 32, 15, 4, 21, 2, 25, 17, 34, 6,
            27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1,
            20, 14, 31, 9, 33, 28, 39, 7, 28, 12, 35, 3, 26};

    private static final int[] american = {0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1, 0,
            27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2};

    private int sumMax(int[] arrays, int n) {
        int ans = getSum(arrays,0,n);
        int temp = ans;
        for (int i = 0, length = arrays.length; i < length; i++) {
                temp += arrays[(i+n)%length];  //越界的直接用取余来算  收悉取余的用法！
                temp -= arrays[i];
                ans = Math.max(ans,temp);
        }

        return ans;
    }



    private int getSum(int[] array, int begain, int end) {
        int count = 0;
        for (int i = 0; i < end; i++) {
            count += array[i];
        }
        return count;
    }

}
