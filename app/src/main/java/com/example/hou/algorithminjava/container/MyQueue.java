package com.example.hou.algorithminjava.container;


//循环队列

public class MyQueue {

    private int[] datas; // 存放数据的数组
    private int head; // 头下标，存放队头在数组的位置
    private int tail; // 尾下标，存放队尾在数组的位置
    private int size; //队列可使用的最大容量就是数据大小
    private int length;  //队列总长度


    private MyQueue() {
    }

    private static class Hodler {
        static MyQueue INSTACE = new MyQueue();
    }

    /*
     * 单例模式
     * */
    public static MyQueue getInstance() {
        return Hodler.INSTACE;
    }

    public MyQueue setSize(int size) {
        this.datas = new int[size];    //初始化size大小的数组
        this.head = -1;                //因为是空队列，所以头下标和尾下标暂时为-1，表示空表
        this.tail = -1;
        this.length = 0;
        this.size = size;
        return this;
    }

    //判断是否是空队列
    private boolean isEmpty() {
        return this.head == this.tail;
    }

    //返回队列长度
    public int getLength() {
        return this.length;
    }


    //进队 从队尾进入队列
    public boolean enQueue(int data) {
        if (isEmpty()) {
            this.head = 0;
        }
        if ((this.tail +1)%size==this.head) {  //如果队列满了  注意取余的用法来判断假溢出！
            return false;
        } else {
            this.datas[++this.tail] = data;  //为其赋值
            this.length++;
            return true;
        }
    }

    //出队
    public int deQueue()throws Exception{
        if (this.head==this.tail||this.head==-1){
            throw new Exception("队列空 无法出队列");
        }
        int tempData = this.datas[this.head];
        this.length -- ;   //长度减一
        this.head++;       //下标加一
        return tempData;
    }



    public void show(){
        for (int i=this.head;i<=this.tail;i++){
            System.out.println(datas[i]+"是队列中元素");
        }
    }


}
