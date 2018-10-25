package com.example.hou.algorithminjava.practice;

public class QueryStr {

    /**
     * http://www.jiuzhang.com//solutions/implement-strstr
     */
    class Solution {
        /**
         * Returns a index to the first occurrence of target in source,
         * or -1  if target is not part of source.
         *
         * @param source string to be scanned.
         * @param target string containing the sequence of characters to match.
         */
        public int strStr(String source, String target) {
            if (source == null || target == null) {
                return -1;
            }

            /**
             *
             * 边界检查之下标溢出：注意变量i的循环判断条件，
             * 如果是单纯的i < source.length()则在后面的source.charAt(i + j)时有可能溢出。
             */
            int i, j;
            for (i = 0; i < source.length() - target.length() + 1; i++) {
                for (j = 0; j < target.length(); j++) {        //j 是目标数组的下标   如果能够匹配 j就++
                    if (source.charAt(i + j) != target.charAt(j)) {
                        break;
                    } //if
                } //for j
                if (j == target.length()) {                     //若是j下标 是目标数组的长度 则 成功
                    return i;
                }
            } //for i

            // did not find the target
            return -1;
        }
    }


    /**
     * 判断两个字符串是否互为变位词，若区分大小写，考虑空白字符时，
     * 直接来理解可以认为两个字符串的拥有各不同字符的数量相同。
     * 对于比较字符数量的问题常用的方法为遍历两个字符串，
     * 统计其中各字符出现的频次，若不等则返回false.
     * 有很多简单字符串类面试题都是此题的变形题！！！
     *
     *
     *
     * 两个字符串长度不等时必不可能为变位词(需要注意题目条件灵活处理)。
     * 初始化含有256个字符的计数器数组。
     * 对字符串 s 自增，字符串 t 递减，再次遍历判断letterCount数组的值，小于0时返回false.
     * 在字符串长度较长(大于所有可能的字符数)时，还可对第二个for循环做进一步优化，
     * 即t.size() > 256时，使用256替代t.size(), 使用i替代t[i].
     *
     * */

    boolean anagram(String s,String t){
        if (s.isEmpty()||t.isEmpty()){
            return false;
        }
        if (s.length()!=t.length()){
            return false;
        }

        int [] letterCount = new int[256];

        for (int i = 0; i != s.length(); ++i) {
            ++letterCount[s.charAt(i)];
            --letterCount[t.charAt(i)];
        }
        for (int i = 0; i != t.length(); ++i) {
            if (letterCount[t.charAt(i)] != 0) {
                return false;
            }
        }
        return true;
    }

}
