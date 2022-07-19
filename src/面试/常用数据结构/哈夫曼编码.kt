package 面试.常用数据结构

import java.util.*

/**
 * 哈夫曼编码：根据读入的一段电文，统计电文中的每一个字符出现的频率，构建哈夫曼树，为该段电文设计哈夫曼编码并编译
 * 哈夫曼树，又称最优二叉树，是带权路径长度最短的树，
 * 用途：构造最优编码，用于信息传输，数据压缩
 * 哈夫曼树的数据结构：静态三叉链表
 */
//树结点
internal class Node(var data: String?,  var weight: Int) {
    var leftNode: Node? = null
    var rightNode: Node? = null
    override fun toString(): String {
        return "Node[data=$data,weight=$weight]"
    }
} //哈夫曼树

internal class HuffmanTree {
    private val nodes: MutableList<Node> = ArrayList() //节点集合
    fun addNode(node: Node): HuffmanTree {     //添加节点
        nodes.add(node)
        return this
    }

    //生成哈夫曼树，返回根结点
    fun createHuffmanTree(): Node {
        //当结点集合中只有一个结点（即根结点）时结束
        while (nodes.size > 1) {
            //对当前结合中的结点进行排序(结点集合中的结点个数每次都会改变)
            sortNode()
            //取到两个权值最小的结点
            val left = nodes[0]
            val right = nodes[1]
            //新结点
            val newNode = Node(null, left.weight + right.weight)
            newNode.leftNode = left
            newNode.rightNode = right
            //移除两个最小的结点
            nodes.removeAt(0)
            nodes.removeAt(0)
            nodes.add(newNode) //添加新结点
        }
        return nodes[0] //返回根结点
    }

    private fun sortNode() {  //排序
        Collections.sort(nodes, Comparator.comparingInt { a: Node -> a.weight })
    }

    //广度优先遍历（需要借助队列）
    fun breadthFirst(root: Node?): List<Node?> {
        //保存结果集
        val lists: MutableList<Node?> = ArrayList()
        //队列
        val queue: Queue<Node?> = ArrayDeque()
        if (root != null) {
            //加入结点到队列中
            queue.offer(root)
        }
        //如果队列为空，则结束
        while (!queue.isEmpty()) {
            //peek方法不移除结点
            lists.add(queue.peek())
            //弹出且移除
            val p = queue.poll()
            //如果左结点不为空，则加入队列
            if (p!!.leftNode != null) {
                queue.offer(p.leftNode)
            }
            //如果右结点不为空，则加入队列
            if (p.rightNode != null) {
                queue.offer(p.rightNode)
            }
        }
        return lists
    }
} //哈夫曼编码实现类

internal class HuffmanCoding {
    var map: MutableMap<String?, String> = HashMap()
    fun coding(root: Node?): Map<String?, String> {
        process(root, "")
        return map
    }

    private fun process(node: Node?, content: String) {
        //叶子结点
        if (node!!.leftNode == null) {
            map[node.data] = content
            return
        }
        //对左子树分配代码"0"
        process(node.leftNode, content + "0")
        //对右子树分配代码"1"
        process(node.rightNode, content + "1")
    }
}

object 哈夫曼编码 {
    @JvmStatic
    fun main(args: Array<String>) {
        val tree = HuffmanTree()
        tree.addNode(Node("A", 40))
            .addNode(Node("B", 8))
            .addNode(Node("C", 10))
            .addNode(Node("D", 30))
            .addNode(Node("E", 10))
            .addNode(Node("F", 2))
        val root = tree.createHuffmanTree()
        val coding = HuffmanCoding()
        val map = coding.coding(root)
        for (str in map.keys) {
            println(str + ":" + map[str])
        }
    }
}
