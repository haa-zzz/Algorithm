package AlgorithmByKotlin

import bean.TreeNode

class 二叉树展开为链表Kotlin_114 {
    /*
   给你二叉树的根结点 root ，请你将它展开为一个单链表：

    展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    展开后的单链表应该与二叉树 先序遍历 顺序相同。
    */
    /*
        方法1.借助集合通过先序遍历把每一个节点先存入集合中，然后遍历集合建立链表关系
        时间复杂度O(N)
        空间复杂度O(N)
     */

    fun flatten(root: TreeNode?): Unit {
        val list : MutableList<TreeNode> = ArrayList()
        preorder(root, list)
        for( i in 1 until list.size){
            val pre = list[i - 1]
            val cur = list[i]
            pre.left = null
            pre.right = cur
        }

    }

    private fun preorder(root: TreeNode?, list: MutableList<TreeNode>) {
        if(root == null){
            return
        }
        list.add(root)
        if(root.left != null){
            preorder(root.left, list)
        }
        if(root.right != null){
            preorder(root.right, list)
        }
    }

    /*
    方法2.
        直接插入，对于每一个节点，我们需要对它进行的操作是：
            1.将左子树插入到右子树的地方
            2.将原来的右子树接到左子树的最右边节点
            3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
         时间复杂度O(N)
         空间复杂度O(1)
     */
    /*
    递归构建：
     */
    fun flatten1(root: TreeNode?): Unit {
        if(root == null)
            return
        if(root.left != null){
            var leftNode = root.left
            while(leftNode.right != null)
                leftNode = leftNode.right
            leftNode.right = root.right
            root.right = root.left
            root.left = null
        }
        flatten(root.right)
    }
    /*
    循环构建：
     */
    fun flatten2(root: TreeNode?): Unit {
        var node = root
        while (node != null) {
            //左子树为 null，直接考虑下一个节点
            if (node.left == null) {
                node = node.right
            } else {
                // 找左子树最右边的节点
                var pre = node.left
                while (pre.right != null) {
                    pre = pre.right
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = node.right
                // 将左子树插入到右子树的地方
                node.right = node.left
                node.left = null
                // 考虑下一个节点
                node = node.right
            }
        }
    }
}