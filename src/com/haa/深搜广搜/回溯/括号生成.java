package com.haa.深搜广搜.回溯;
import java.util.ArrayList;
import java.util.List;


public class 括号生成 {
    /*
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */

    /*
    方法1.深度优先搜索（回溯法）
        1.递归
            可以维护一个path字符串，递归的去查找对应的符合条件的字符串。如果当前状态找不到，就回溯。
            括号数为 n，那么一个合法的括号组合，应该包含 n 个左括号和 n 个右括号，组合总长度为 2n。
            一对合法的括号，应该是先出现左括号，再出现右括号。那么意味着任意一个右括号的左边，至少有一个左括号
            我们可以设定一个初始值为 0 的得分值，往组合添加一个 “( ” 得分值 + 1，往组合添加一个 “)” 得分值 -1。
        2.找递归条件
            注意两个隐含条件：
                1.括号数为 n，那么一个合法的括号组合，应该包含 n 个左括号和 n 个右括号，组合总长度为 2n。
                2.一对合法的括号，应该是先出现左括号，再出现右括号。那么意味着任意一个右括号的左边，至少有一个左括号
             我们可以设定一个初始值为 0 的得分值，往组合添加一个 “( ” 得分值 + 1，往组合添加一个 “)” 得分值 -1。
             所以可以递归添加左括号的条件为：
                    score + 1 <= n  即得分不多于n就可以添加。
                可以递归添加右括号的条件为：
                    score - 1 >= 0，即要保证右括号前有足够的左括号与之对应。
         3.找终止条件
               当字符串长度 == 2*n ,时终止
                    如果score==0(即都是匹配的括号时)，添加到集合中


     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(0,n*2,0,n,"",ans);
        return ans;
    }

    private void dfs(int i, int n, int score, int max, String path, List<String> ans) {
        if( i == n){
            if(score==0)
                ans.add(path);
        }else {
            // 如果添加左括号后不超过 max（有效值），则可以添加
            if (score + 1 <= max) {
                dfs(i + 1, n, score + 1, max, path + "(", ans);
            }

            // 如果添加右括号后不少于 0（有效值），则可以添加
            if (score - 1 >= 0) {
                dfs(i + 1, n, score - 1, max, path + ")", ans);
            }
        }
    }
    /*
    方法2：回溯(基于上面的dfs)

        1.思想：
            如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。这样找到的每一个都是有效的括号
        2.找结束条件
              当字符串长度 == 2*n ,时终止
        时间复杂度 每个答案需要O(N)时间去寻找
        空间复杂度 O(n)
     */

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    private void backtrack(List<String> ans, StringBuilder path, int left, int right, int max) {
        if(path.length() == max * 2){
            ans.add(path.toString());
            return;
        }
        if(left < max){
            path.append('(');                   //做出选择
            backtrack(ans,path,left+1,right,max);            //递归进下一层，添加下一个括号
            path.deleteCharAt(path.length()-1);         //回溯
        }
        if( right < left){
            path.append(')');
            backtrack(ans,path,left,right+1,max);
            path.deleteCharAt(path.length()-1);
        }
    }

}
