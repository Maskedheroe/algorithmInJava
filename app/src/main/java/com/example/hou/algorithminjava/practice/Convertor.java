package com.example.hou.algorithminjava.practice;

import com.example.hou.algorithminjava.container.LinkStack;

public class Convertor {

    public static void main(String[] args) throws Exception {
        // write your code here
        conversion(170,16);
//        System.out.println(Integer.toHexString(100));
    }


    private static void conversion(int number,int target) throws Exception {
        LinkStack stack = new LinkStack();
        int result = 0;
        if (number==0||target==0){
            System.out.println("ERROR!");
            return;
        }
        switch (target){
            case 2:
                convert(number, stack,2);
                break;
            case 8:
                convert(number,stack,8);
                break;
            case 10:
                convert(number,stack,10);
                break;
            case 16:
                convert(number,stack,16);
                break;
        }

    }



    private static void convert(int number, LinkStack stack,int type) throws Exception {
        Object result;
        String [] array = {"a","b","c","d","e","f"};


        while(number!=0) {
            /**
             * 对16取余如果大于10 就进行判断 再对10取余——>对应string数组
             *
             * */
            stack.Push(type==16?(number%type>=10?array[(number%type)%10]:number%type):number % type);
            number /= type;
        }
        while (!stack.isEmpty()){
            result = stack.Pop();
            System.out.print(result);
        }
    }

}