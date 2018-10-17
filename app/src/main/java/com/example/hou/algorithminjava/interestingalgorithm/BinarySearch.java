package com.example.hou.algorithminjava.interestingalgorithm;


//二分搜索
/*
* 二分搜索是一种在有序数组中寻找目标值的经典方法，也就是说使用前提是『有序数组』。
* 非常简单的题中『有序』特征非常明显，但更多时候可能需要我们自己去构造『有序数组』。
* 下面我们从最基本的二分搜索开始逐步深入。
 * */

public class BinarySearch {

    public static int lowerBound(int[]nums,int target){   //定义 lower bound 是在给定升序数组中 大于等于目标值的最小索引
        if (nums==null||nums.length==0)return -1;   //写算法-》 1、异常和边界 2、主体 3、返回

        /**
         *  这样的初始化比起  0 和 nums.length - 1 有三个优点
         *
         * 1、目标值在数组范围之内 返回值必为lb+1
         * 2、目标值比数组最小值还小(比最小的还小)，此时lb 一直为-1, 故最后返回lb + 1 也没错，也可以将-1 理解为数组前一个更小的值
         * 3、目标值大于等于数组最后一个值(比最大的还大)，由于循环退出条件为+ 1 ==, 那么循环退出时一定有lb = A.length - 1, 应该返回lb + 1
         *
         * 其实以上三种情况都可以统一为一种方式来理解，即索引-1 对应于数组前方一个非常小的数，
         * 索引ub 即对应数组后方一个非常大的数，那么要插入的数就一定在lb 和ub 之间了。
         * */
        int lowBound = -1,upBound = nums.length;



        while (lowBound+1<upBound){       //为什么不是等号?  因为取等号可能造成死循环(因为upBound在变化) 所以这样写的好处是  最后退出循环时一定是 lb+1==up(就是这一段以及处理完毕)
            int mid = lowBound + (upBound - lowBound)/2;       //可以防止两数相加后溢出边界
            if (nums[mid]<target){  //如果不符合(小于目标)
                lowBound = mid;
            }else {                 //如果符合(大于等于目标)
                upBound = mid;
            }
        }

        return lowBound+1;
    }


    /*
     * nums[index] <= target, max(index)
     */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }

    public static void test() {
        int[] nums = new int[]{1,2,2,3,4,6,6,6,13,18};
        System.out.println(lowerBound(nums, 6)); //answer 5
        System.out.println(upperBound(nums, 6)); //answer 7
        System.out.println(lowerBound(nums, 7)); //answer 8
        System.out.println(upperBound(nums, 7)); //answer 7
    }

}
