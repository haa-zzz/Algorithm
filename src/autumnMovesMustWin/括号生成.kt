package autumnMovesMustWin

/*
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 力抠：22
 */

/**
    方法：回溯
        1.思想：
            如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。这样找到的每一个都是有效的括号
        2.找结束条件
              当left == n && right == n ,时终止
        时间复杂度 :每个答案需要O(N)时间去寻找
        空间复杂度 :O(n) 栈深度最深为n
     */
fun generateParenthesis(n: Int): List<String> {
    val ans = arrayListOf<String>()
    backtrack(n, 0, 0, StringBuilder(), ans)
    return ans
}
fun backtrack(n: Int, left: Int, right: Int, path: StringBuilder, ans: MutableList<String>) {
    if(left == n && right == n) {
        ans.add(path.toString())
    }
    if(left < n) {
        path.append('(')
        backtrack(n, left+1, right, path, ans)
        path.deleteCharAt(path.length-1)
    }
    if(right < left) {
        path.append(')')
        backtrack(n, left, right+1, path, ans)
        path.deleteCharAt(path.length-1)
    }
}

/**
 * java
 */
/*

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
}*/
