package com.example.hou.algorithminjava.practice;

public class QueryStr {

    /**
     * http://www.jiuzhang.com//solutions/implement-strstr
     */
    class Solution {
        /**
         * Returns a index to the first occurrence of target in source,
         * or -1  if target is not part of source.
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

}
