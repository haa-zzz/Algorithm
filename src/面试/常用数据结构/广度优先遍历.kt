package 面试.常用数据结构

import java.util.*

/**
 * BFS是从根节点开始，沿着树(图)的宽度遍历树(图)的节点。
    如果所有节点均被访问，则算法中止。
 */

internal class TreeNode(var `val` : Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
private fun bfsMS(node: TreeNode): List<TreeNode> {
    val list = mutableListOf<TreeNode>()
    val queue = LinkedList<TreeNode>()

    queue.offer(node)

    while(queue.isNotEmpty()) {
        val p = queue.poll()
        list.add(p)
        if(p.left != null) {
            queue.offer(p.left)
        }
        if(p.right != null) {
            queue.offer(p.right)
        }
    }
    return list
}