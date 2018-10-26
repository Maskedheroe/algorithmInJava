package com.example.hou.algorithminjava.container;

public class LinkStack {
    //链式栈
    private int mCount = 0;

    private StackNode top = null;


    public LinkStack(){

    }

    public boolean isEmpty(){
        return mCount==0||top==null;
    }

    class StackNode{
        //栈节点

        Object data = 0;

        StackNode next = null;

        StackNode(Object data){
            this.data = data;
        }
    }


    public boolean Push(Object data){
        StackNode s = new StackNode( data);
        s.next = this.top;  //把当前栈顶元素赋值给新节点的直接后继
        this.top = s;
        this.mCount ++ ;
        return  true;
    }

    public Object Pop() throws Exception {
        StackNode node = new StackNode(0);
        Object temp = 0;
        if (mCount==0){
            throw new Exception("栈为空");
        }
        temp = this.top.data;
        node = this.top;
        this.top = this.top.next;
        System.gc(); //垃圾回收
        this.mCount--;
        return temp;
    }

    public boolean clearLinkStack(){
        StackNode node = new StackNode(0);
        while (node==this.top){
            this.top = this.top.next;
            System.gc(); //回收垃圾
        }
        return true;
    }

    public int linkedListLength(){
        return mCount;
    }

    public Object GetLinkStackTop(){
        return (this.top==null)?0:this.top.data;
    }

    public void printLinkStack(){
        StackNode node = new StackNode(0);
        node = this.top;
        while (node!=null){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(node.data);
            node = node.next;
        }
    }
}

