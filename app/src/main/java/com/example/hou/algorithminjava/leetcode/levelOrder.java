
//层次先序遍历 树 的算法 （自己创造的智慧！！）
public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {//异常处理
            return new ArrayList<>();
        }
        List<List<Integer>> listOfSum = new ArrayList();  //用来存储所有层次的的列表的总列表
        ArrayList<Integer> valList = new ArrayList<>();        //用来存储每一层的值的列表
        LinkedList<Node> manager = new LinkedList<>();      //管理者
        LinkedList<Node> arraylistOfLayer = new LinkedList<>();  //来存储这一层级的子节点
        arraylistOfLayer.add(root);
        manager.addAll(arraylistOfLayer);                 //交给队列来管理 存储所有节点
        arraylistOfLayer.clear();                         //存储好了这一层就清空
        while (manager.peekFirst()!= null) {
            Node popNode = manager.pop();
            final int val = popNode.val;
            valList.add(val);

            if (popNode.children!=null&&popNode.children.size()>0){//如果该节点有子节点 就暂入这一层的列表
                arraylistOfLayer.addAll(popNode.children);
            }
            if (manager.size()==0&&arraylistOfLayer.size()>=0){  //如果管理者为空了 就把下一层的所有节点入队
                ArrayList<Integer> temp = (ArrayList<Integer>) valList.clone();
                listOfSum.add(temp);
                manager.addAll(arraylistOfLayer);
                arraylistOfLayer.clear();  //清空层列表
                valList.clear();//清空值列表
            }


        }

        return listOfSum;
    }
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
