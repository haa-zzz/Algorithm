package com.haa.栈和队列;

import java.util.*;

public class 克隆图 {
    /*
    给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。

    图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。

     */

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    /*
    方法一.深度优先搜索，从给定的节点出发，进行图的遍历，并在遍历的过程中完成图的深拷贝。
        注意：每个节点只能拷贝一次，我们需要记录当前节点是否被访问过，为此我们需要用到哈希表
        时间复杂度O(N)  空间复杂度O(N)
     */
    HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        //如果访问过，直接在哈希表中寻找对应节点
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        //没有访问过，创建新节点，并加入到集合中
        Node cloneNode = new Node(node.val,new ArrayList<>());
        visited.put(node,cloneNode);
        //dfs遍历
        for(Node neighbor : node.neighbors){
            cloneNode.neighbors.add( cloneGraph(neighbor) );
        }
        return cloneNode;
    }
    /*
    方法2.广度优先搜索，遍历方式变为bfs，其他和上面的类似
     */
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        //把第一个节点克隆
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node head = queue.poll();
            for(Node neighbor : head.neighbors){
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    //将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(head).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}
