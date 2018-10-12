

public class LinkedList {

    private static int mSize = 0;
    private Node mHeadNode = null;
    private Node mCurrentEndNode = null;

    public LinkedList(){
        this(0);
    }

    public LinkedList(int size){ //使用构造函数初始化
        mSize = size;
        mHeadNode = new Node<>("首节点",null);
        mCurrentEndNode = mHeadNode;
    }



    public boolean add(String data){   //在表尾增加一个元素
        Node newNode =  new Node(data,null);
        if (mCurrentEndNode == null){
            mCurrentEndNode = newNode;
        }else {
            if (mCurrentEndNode.nextNode!=null){
                mCurrentEndNode.nextNode.nextNode = newNode;

            }//找到最后一个结点
            mCurrentEndNode.nextNode = newNode;
        }
        mCurrentEndNode = newNode;
        mSize++;
        return true;
    }

    public String GetSingleLinkListElem(int position){  //获取某个元素

        if (position>mSize&&position<mSize){
            return null;
        }else {
            int k = 0;
            while (k<position){
                mHeadNode = mHeadNode.nextNode;
                k++;
            }
            return mHeadNode.getT().toString();

        }


    }


    boolean InsertSingleLinkList(String nodeData,int position){  //在该位置插入一个元素


        Node newNode = new Node(nodeData,null);
        int j = 0;
        while (this!=null&&(j<position-1)){
            mHeadNode = mHeadNode.nextNode;
            ++j;
        }
        if (mHeadNode==null||j>position-1){
            //为空链表 或者插入位置不合法
            return false;
        }
        newNode.priNode = mHeadNode;
        newNode.nextNode = mHeadNode.nextNode;
        mHeadNode.nextNode.priNode = newNode;
        mHeadNode.nextNode = newNode;
        return true;

    }


    boolean DeleteSingleLinkList(int position){   //删除该位置元素
        int k=0;
        Node temp = mHeadNode;
        if (position<1||position>mSize){
            return false;
        }
        while (temp!=null&&k<position-1){
            k++;
            temp = temp.nextNode;
        }

        temp.priNode.nextNode = temp.nextNode;
        temp.nextNode.priNode = temp.priNode;
        return true;
    }

    public void PrintSingleLinkList(){ //打印元素

        for (Node i = mHeadNode;i!=null;i=i.nextNode){
            System.out.println(i.getT());
        }
    }

    public int getSingleLinkListLength(){
        return mSize;
    }

    //链表是否为空
    public boolean SingleLinkListEmpty()
    {
        return mSize == 0;
    }

    public boolean removeNode(String data){//删除元素

        if (mHeadNode==null){
            return false;
        }
        Node temp = mHeadNode;
        if (temp.getT() == data){
            mHeadNode = temp.nextNode;
            return true;
        }else {
            while (temp.nextNode!=null&&temp.nextNode.getT()!=data){
                temp = temp.nextNode;
            }
            if (temp.nextNode.getT() == data){  //如果找到了要删除的节点 那其上一个节点是temp
                temp.nextNode = temp.nextNode.nextNode;  //将待删除的节点的上一个节点 指向下下一个节点
                return true;   //删除成功
            }else {
                return false;
            }
        }

    }



    //静态内部类 单项链表
    private static class Node<T> {
        T t;  //泛型 使用时进行类型转换
        Node<T> nextNode;
        Node<T> priNode;

        public T getT() {
            return t;
        }

        public Node(T t, Node<T> nextNode) {
            this.nextNode = nextNode;
            this.t = t;
        }
    }



}
