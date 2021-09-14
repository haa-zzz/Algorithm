@file:Suppress("NAME_SHADOWING")

package AlgorithmByKotlin

import bean.TreeNode
import java.util.*
import kotlin.contracts.contract

class 对称二叉树Kotlin_101 {
    /*
    给定一个二叉树，检查它是否是镜像对称的。
     */
    /*
   方法一.递归，设置两个指针同步移动来遍历，一个指针指向对应的左树，另一个指向对应的右树，检查是否相等
    */
    fun isSymmetric(root: TreeNode?): Boolean {
        return check(root,root)
    }
    private fun check(left : TreeNode?, right : TreeNode? ) : Boolean{
        if(left == null && right == null){      //终止条件，两个都是空树，此时是对称的
            return true
        }
        if(left == null || right == null){      //一个为空，另一个不为空，此时是不对称的
            return false
        }
        return ( left.`val` == right.`val` && check(left.left,right.right)
                && check(left.right,right.left) )        //判断是否相等+递归
    }
    /*
   方法2.迭代实现，借助队列每次入队左右对应的两个节点，并同时判断对应的节点是否相同
    */
    fun isSymmetric1(root: TreeNode?): Boolean {
        return check1(root,root)
    }

    private fun check1(left : TreeNode?, right: TreeNode?): Boolean {
        val queue : Queue<TreeNode> = LinkedList()
        queue.offer(left)
        queue.offer(right)
        while(!queue.isEmpty()){
            val left = queue.poll()
            val right = queue.poll()
            if(left == null && right == null){
                continue
            }
            if( (left == null || right == null) || (left.`val` != right.`val`)){
                return false
            }
            queue.offer(left.left)
            queue.offer(right.right)
            queue.offer(left.right)
            queue.offer(right.left)
        }
        return true
    }

}