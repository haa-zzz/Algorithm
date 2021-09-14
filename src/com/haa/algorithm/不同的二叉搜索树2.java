package com.haa.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树2 {
    /*
    给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
    示例：
    输入：3
    输出：
    [
      [1,null,3,2],
      [3,2,null,1],
      [3,1,null,null,2],
      [2,1,3],
      [1,null,2,null,3]
    ]
    解释：
    以上的输出对应以下 5 种不同结构的二叉搜索树：

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /*
        方法一：递归，递归计算每种可能

        临界点：
            1，当start>end时，此时构不成树，所以添加null
            2,当start==end时，只有一个节点，只能构成一颗树，添加new TreeNode(start)
        一般情况，遍历每个节点，吧次节点作为根节点，递归找他的左右子数
     */

    /*
    public List<TreeNode> generateTrees(int n) {
       List<TreeNode> list = new ArrayList<>();
       if(n==0)
           return list;
       else
           return getAns(1,n);


    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        if(start==end){
            list.add(new TreeNode(start));
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = getAns(start,i-1);
            List<TreeNode> right = getAns(i+1,end);
            for(TreeNode leftTree:left){
                for(TreeNode rightTree:right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    list.add(root);
                }
            }
        }
        return list;

    }

     */
    /*
    方法二：动态规划
    和递归思想相同，

     */
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n+1];
        dp[0] = new ArrayList<TreeNode>();

        if(n==0)
            return dp[0];
        dp[0].add(null);

        for(int i = 1; i <= n; i++){
            dp[i] = new ArrayList<>();
            for(int root = 1; root <= i; root++ ){
                int left = root-1;
                int right = i-root;
                for(TreeNode leftTree:dp[left]){
                    for(TreeNode rightTree:dp[right]){
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        treeRoot.right = clone(rightTree, root);
                        dp[i].add(treeRoot);
                    }
                }
            }

        }
        return dp[n];

    }
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
