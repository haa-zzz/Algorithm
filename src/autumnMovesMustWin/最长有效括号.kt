package autumnMovesMustWin

/*
    给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    力抠32
     */
/**
方法1：动态规划+标记
这道题和最大子序列的思路基本一样
用dp数组记录以第i个字符结尾的最长有效括号,用ans标记整个字符串的最长有效括号，在填表的过程中，用这个数和dp[i]比较，取最大值。
    第 1 步：定义状态
        dp[i]: 表示第i个字符结尾的最长有效括号
    第 2 步: 思考状态转移方程
        如果i位置是‘(’ 那么dp[i] = 0
        如果i位置是‘)’,分两种情况讨论
            第一种：i-1位置为‘(’  对于与dp[i] = dp[i-2] + 2
            第二种：i-1位置为‘)’  那么i位置的对应‘(’如果存在，应该在 i - dp[i-1] - 1的位置，
                此时还要加上前面的有效括号长度，比如 ()(())这种情况
                dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
    第 3 步: 考虑初始化
        dp[0] = 0 ，第一个字符对应的有效括号长度为0

时间复杂度 O(N)
空间复杂度O(N)
 */
fun longestValidParentheses(s: String): Int {
    var ans = 0
    val len = s.length
    val dp = IntArray(len+1)
    for( i in 2..len) {
        if(s[i-1] == ')') {
            if(s[i-2] == '(') {
                dp[i] = dp[i-2] + 2
            } else if(i - dp[i-1] -2 >= 0 && s[i - dp[i-1] -2] == '('){
                dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
            }
        }
        ans = Math.max(ans, dp[i])
    }
    return ans
}
/**
 * java
 */
/*
public int longestValidParentheses(String s) {
    int ans = 0;
    int[] dp = new int[s.length()];
    for(int i = 1; i < s.length(); i++){
        if(s.charAt(i) == '('){
            dp[i] = 0;
        }else{
            if(s.charAt(i-1) == '('){
                dp[i] = ( i-2 >= 0 ? dp[i-2]:0 ) + 2;
            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            ans = Math.max(ans, dp[i]);
        }
    }
    return ans;
}
*/

/**
 * 方法2：正逆项结合
 *  这是一种比较巧妙的做法，贪心的去查找。用left, Right 分别去记录左右括号数量
 *  如果从左到右遍历， 如果left < Right,那前面的一串一定是无效的，将left,right重新置为0
 *  由于只有一种括号，这样的话，当且仅当 left == right 时是有效的
 *  此时对于 left > right的情况无法进行判定，比如(()。我们可以从右向左再遍历一遍，这样就包含了所以情况
 */
fun longestValidParenthesesByMethod2(s: String): Int {
    var left = 0
    var right = 0
    var ans = 0
    s.forEach {
        if(it == '(') {
            left++
        } else {
            right++
        }

        if(left == right) {
            ans = Math.max(ans,left*2)
        }else if(left < right) {
            left = 0
            right = 0
        }
    }
    left = 0
    right = 0
    for (i in s.length - 1 downTo 0) {
        if (s[i] == '(') {
            left++
        } else {
            right++
        }
        if (left == right) {
            ans = Math.max(ans, right * 2)
        }
        if (right < left) {
            right = 0
            left = right
        }
    }
    return ans
}

/**
 * java
 */
/*
public int longestValidParentheses1(String s) {

    int ans = 0;
    int left = 0,right = 0;
    for(int i = 0;  i < s.length(); i++ ){
        if(s.charAt(i) == '('){
            left++;
        }else{
            right++;
        }
        if(left == right){
            ans = Math.max(ans,right*2);
        }
        if(right > left){
            left = right = 0;
        }
    }
    left = right = 0;
    for(int  i = s.length()-1; i >= 0; i-- ){
        if(s.charAt(i) == '('){
            left++;
        }else{
            right++;
        }
        if(left == right){
            ans = Math.max(ans,right*2);
        }
        if(right < left){
            left = right = 0;
        }
    }
    return ans;
}*/
