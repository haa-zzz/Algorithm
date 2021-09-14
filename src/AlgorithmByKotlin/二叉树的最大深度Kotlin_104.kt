package AlgorithmByKotlin

import bean.TreeNode
import java.util.*

class 二叉树的最大深度Kotlin_104 {
    //bfs 广度优先搜索，利用层次遍历来找
    fun maxDepth1(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        var ans = 0
        while (!queue.isEmpty()) {
            var size = queue.size
            while (size > 0) {
                val node = queue.poll()
                if (node.left != null) queue.offer(node.left)
                if (node.right != null) queue.offer(node.right)
                size--
            }
            ans++
        }
        return ans
    }
}