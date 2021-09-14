package AlgorithmByKotlin

import bean.TreeNode
import java.util.*

class 二叉树的层次遍历Kotlin_102 {

    /*
    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

     */
    /*
    方法：bfs，使用栈来一次存储访问一层
        时间复杂度O(N)
        空间复杂度O(N)
     */


    fun levelOrder(root: TreeNode?): List<List<Int>>? {

        val lists: MutableList<List<Int>> = ArrayList()
        if (root == null) {
            return lists
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val list: MutableList<Int> = ArrayList()
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.poll()
                list.add(node.`val`)
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            lists.add(list)
        }
        return lists

    }
}