package com.example.hou.algorithminjava.container;



public class TreeOfBST<Key extends Comparable<Key>,Value> {

    private Node root;

    class Node{
        private Key key;
        private Value value;
        Node left,right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.N = n;
        }
    }

    public int getSize(){
        return size(root);
    }
    private int size(Node x){
        if (x==null){
            return 0;
        }else {
            return x.N;
        }
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x,Key key){
        //在以x为根结点的子树中查找并返回key所对应的值
        //如果找不到则返回null
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp<0){
            return get(x.left,key);
        }else if (cmp>0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }

    public void put(Key key,Value value){
        put(root,key,value);
    }

    private Node put(Node root, Key key, Value value) {
        //如果key 存在以root为结点的字数中则更新它的值
        //否则将以key和value为键值对的新结点插入该子树中
        if (root==null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(root.key);
        if (cmp==0){
            root.value = value;
        }else if (cmp>0){
            root.right = put(root.right,key,value);
        }else {
            root.left = put(root.left,key,value);
        }
        root.N = size(root.left) + size(root.right) + 1; //加上当前的
        return root;
    }

}
