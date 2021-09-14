package AlgorithmByKotlin

import bean.TreeNode
import java.util.*
import kotlin.collections.ArrayDeque as ArrayDeque1

class 验证二叉搜索树Kotlin_98 {
    /*
    给定一个二叉树，判断其是否是一个有效的二叉搜索树。
       假设一个二叉搜索树具有如下特征：
        节点的左子树只包含小于当前节点的数。
        节点的右子树只包含大于当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
     */
    /*
    方法1：递归
        二叉搜索树的左子树的节点均小于根节点，右子树的节点均大于根节点。
        为此我们在判断时需要提供一个区间.
            根节点的左子树应该都在(Integer.MIN_VALUE,root.val)这个开区间内，
            根节点的右子树应该都在(root.val,Integer.MAX_VALUE)这个开区间内
        按这个条件去递归
     */
    fun isValidBST(root: TreeNode?): Boolean {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isBST(root: TreeNode?, min: Long, max: Long): Boolean {
        if(root == null)
            return true
        if(root.`val` <= min || root.`val` >= max){
            return false
        }
        return isBST(root.left , min , root.`val`.toLong()) && isBST(root.right, root.`val`.toLong(),max)
    }

    /*
    方法2.中序遍历(递归实现)
        基于二叉搜索树的性质，可以知道二叉搜索树中序遍历得到的值构成的序列一定是升序排列的。可以在中序遍历的时候查看
        当前节点的值是否大于前一个中序节点的值即可。
     */
    private var preVal = Long.MIN_VALUE
    fun isValidBST1(root: TreeNode?): Boolean {
        if(root == null)
            return true
        if(!isValidBST1(root.left)){
            return false
        }
        if(root.`val` <= preVal)
            return false
        preVal = root.`val`.toLong()
        return isValidBST1(root.right)
    }
    /*
    中序遍历(迭代实现)
     */
    fun isValidBST2(root: TreeNode?): Boolean {
        val deque : Deque<TreeNode> = ArrayDeque()
        var node = root
        var preVal = Long.MIN_VALUE
        while(node != null || !deque.isEmpty()){
            while(node != null){
                deque.push(node)
                node = node.left
            }
            if(!deque.isEmpty()){
                node = deque.pop()
                if(node.`val` <= preVal){
                    return false
                }
                preVal = node.`val`.toLong()
                node = node.right
            }
        }
        return true
    }

}
