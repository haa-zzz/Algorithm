package autumnMovesMustWin

/*
给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

力抠： 10
 */

/**
 * 方法：动态规划
 * dp[i][j]表示s的前i个是否可以被p的前j个匹配
 *动态方程推导：
 *  对于dp[i][j]
 *  1. (s[i] == p[j]) or (p[j] == .) -> dp[i][j] = dp[i-1][j-1]
 *  2. p[j] = *
 *      可以这样考虑：(注意*就相当于做乘法，如果*为0，就相当于把前一个消除了)
 *      * == 0 ->  dp[i][j] = dp[i][j-2]   例如(ab, abb*)
 *      * >= 1 && (p[j-1] == s[i] || p[j-1] == '.') -> dp[i][j] = dp[i-1][j] 例如(ab, ab*) (bbbb, b*)
 *      任意成立一个即可
 *初始化
 *  都是空串为true: dp[0][0] = true
 *  dp[0][j]: 既 “###” 匹配 “”,只要a*b*这种可以匹配，其他全是false
 *  dp[i][0]: false
 */

fun isMatch(s: String, p: String): Boolean {
    val lenS = s.length
    val lenP = p.length
    val dp = Array(lenS+1){BooleanArray(lenP+1)}
    dp[0][0] = true
    for (j in 2..lenP step 2) {
        if (p[j-1] == '*') {
            dp[0][j] = true
        } else {
            break
        }
    }
    for(i in 1..lenS) {
        for(j in 1..lenP) {
            if(s[i-1] == p[j-1] || p[j-1] == '.') {
                dp[i][j] = dp[i-1][j-1]
            } else if(p[j-1] == '*') {
                if(dp[i][j-2]) {
                    dp[i][j] = true
                } else if(s[i-1] == p[j-2] || p[j-2] == '.'){
                    dp[i][j] = dp[i-1][j]
                }
            }
        }
    }
    return dp[lenS][lenP]
}

public List<String> binaryTreePaths(TreeNode root) {
    List<Integer> paths = new ArrayList<String>();
    int num = 0;
    constructPaths(root, num, paths);
    //累加过程省略
    println()
    return paths;
}

public void constructPaths(TreeNode root, int num, List<Integer> paths) {
    if (root != null) {
        int num += 0;
        num += (Integer.toString(root.val));
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(num);  // 把路径加入到答案中
        } else {
            // 当前节点不是叶子节点，继续递归遍历
            constructPaths(root.left, num, paths);
            constructPaths(root.right, num, paths);
        }
    }
}

/**
 * java
 */
/*
public boolean isMatch(String s, String p) {
    if (s == null || p == null) return false;

    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;

    for (int i = 2; i <= n; i+= 2) {
        if (p.charAt(i - 1) == '*') {
            dp[0][i] = dp[0][i - 2];
        }
    }

    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
        char sc = s.charAt(i - 1);
        char pc = p.charAt(j - 1);
        if (sc == pc || pc == '.') {
            dp[i][j] = dp[i - 1][j - 1];
        } else if (pc == '*') {
            if (dp[i][j - 2]) {
                dp[i][j] = true;
            } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    }

    return dp[m][n];
}
*/
