package com.example.hou.algorithminjava.interview

class Node {
    public var preNode: Node? = null
    public var nextNode: Node? = null
    public var key: String? = null
    public var value: String? = null

    constructor(key: String, value: String) {
        this.key = key
        this.value = value
    }
}

class LRUCache {
    private var head: Node ? = null
    private var end: Node ? = null

    //缓存上限
    private var limit :Int?= null

    private var hashMap:HashMap<String,Node> ? = null

    constructor(limie: Int?) {
        this.limit = limie
        hashMap = HashMap()
    }

    public fun get(key: String):String?{
        val node : Node = hashMap!![key]!!
        if (node==null){
            return null
        }
        refeshNode(node)
        return node.value
    }

    /**
     * 刷新被访问的节点位置
     *
     *
     * */
    private fun refeshNode(node: Node) {
        //如果 访问的是尾节点的位置 无需移动节点
        if (node==null){
            return
        }

        //移除节点
        removeNode(node)

        //重新插入节点
        addNode(node)
    }

    public fun put(key: String,value: String):Unit{
        var node:Node = hashMap!![key]!!
        if (node==null){
            //如果key不存在 插入key value
            if (hashMap!!.size>=limit!!){
                val oldKey = removeNode(head!!)
                hashMap!!.remove(oldKey)
            }
            node = Node(key,value)
            addNode(node)
            hashMap!!.put(key,node)
        }else{
            //如果key存在 刷新 key - value
            node.value = value
            refeshNode(node)
        }
    }

    /**
     *
     * 在尾部插入节点
     * */
    private fun addNode(node: Node) {
        if (end!=null){
            end!!.nextNode = node
            node.preNode = end
            node.nextNode = null
        }
        end = node
        if (head==null){
            head = node
        }
    }

    /*、
    *
    * 删除节点
    * */
    private fun removeNode(node: Node):String? {
       if (node==end){
           end = end!!.preNode
       }else if (node == head){
           //移除头结点
           head = head!!.nextNode
       }else{
           //移除中间节点
           node.preNode!!.nextNode = node.nextNode
           node.nextNode!!.preNode = node.preNode
       }
        return node.key
    }



}