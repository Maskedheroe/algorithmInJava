package com.example.hou.algorithminjava.interestingalgorithm.binarysearchpractice;


import java.util.Random;

/**
 * 洗牌算法
 */
public class Shuffle {

    public static void shuffleCard(int[] cards) {
        //   Fisher–Yates
        //概述为随机交换一组数的顺序 使得每个元素在每个索引处出现的概率均相等
        //事件复杂度 O(N'2)
        if (cards == null || cards.length == 0) return;

        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {     //重点!!!
            int k = rand.nextInt(i + 1); // 0~i (inclusive)
            int temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
    }


    /**
     * 随机抽样也称为水池抽样，Randomly choosing a sample of k items from a list S containing n items.
     * 大意是从大小为 n 的数组中随机选出 m 个整数，要求每个元素被选中的概率相同。
     * <p>
     * <p>
     * 首先将数组前 m 个元素填充进新数组sample, 然后从m开始遍历直至数组最后一个索引。
     * 随机数k的范围为0~i, 如果k < m，新数组的索引为 k 的元素则和原数组索引为i的元素交换；
     * 如果k >= m, 则不进行交换。i == m时，以原数组中第j个元素为例，它被nums[m]替换的概率为1/(m+1),
     * 也就是说保留在sample数组中的概率为m/(m+1). 对与第m+1个元素nums[m]来说，
     * 其位于sample数组中的概率则为m*1/(m+1)(可替换 m 个不同的元素).
     * <p>
     * 接下来仍然使用数学归纳法证明，若i遍历到r时，其之前的元素出现的概率为m/(r-1),
     * 那么其之前的元素中任一元素nums[j]被替换的概率为m/r * 1/m = 1/r, 不被替换的概率则为(r-1)/r.
     * 故元素nums[j]在i遍历完r后仍然保留的概率为m/(r-1) * (r-1)/r = m/r. 而对于元素nums[r]来说，
     * 其要被替换至sample数组中的概率则为m/r(随机数小于m 的个数为 m).
     * <p>
     * 综上，以上算法在遍历完长度为 n 的数组后每个数出现在最终sample数组中的概率都为m/n.
     */

    public static int[] randomSample(int[] nums, int m) {
        if (nums == null || nums.length == 0 || m <= 0) return new int[]{};

        int[] sample = new int[m];
        for (int i = 0; i < m; i++) {
            sample[i] = nums[i];
        }

        Random random = new Random();
        for (int i = m; i < nums.length; i++) {
            int k = random.nextInt(i + 1); // 0~i(inclusive)
            if (k < m) {                 //重点!!!
                sample[k] = nums[i];
            }
        }

        return sample;
    }
}
