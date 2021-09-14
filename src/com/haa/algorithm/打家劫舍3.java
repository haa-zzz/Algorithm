package com.haa.algorithm;

import java.util.HashMap;

public class 打家劫舍3 {
    /*
    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     */
    /*
        ：最近做题兴趣不高，拿到这道题之后直接看了题解
        分析：
        二叉树:一个爷爷最多 2 个儿子，4 个孙子
        单个点的钱：爷爷+4孙子  或者 2儿子 比较大小       这就是动态规划里面的最优子结构

     */
    /*
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int money = root.val;
        if(root.left!=null){
            money += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            money += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(money,rob(root.left)+rob(root.right));
    }

     */
    //优化：
    public int rob1(TreeNode root) {
        HashMap<TreeNode,Integer> hs = new HashMap<>();
        return robmin(root,hs);
    }

    private int robmin(TreeNode root, HashMap<TreeNode, Integer> hs) {
        if(root==null)
            return 0;
        if(hs.containsKey(root))
            return hs.get(root);
        int money = root.val;
        if(root.left != null){
            money += robmin(root.left.left,hs) + robmin(root.left.right,hs);
        }
        if(root.right!=null){
            money += robmin(root.right.left,hs) + robmin(root.right.right,hs);
        }

        int result =  Math.max(money,robmin(root.left,hs)+robmin(root.right,hs));
        hs.put(root,result);
        return result;
    }
    /*
    第三种解法：
    任何一个节点能偷到的最大钱的状态可以定义为
    当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
    当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
    */
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }


}
