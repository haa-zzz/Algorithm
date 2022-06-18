package AlgorithmByKotlin

import java.util.*


class 单词拆分Kotlin_139 {

    /*
    给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。

    说明：

    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。
     */
    /*
    方法1.dfs
        思路: 对给定的字符串从左到右查找，与每一个单词列表的单词相匹配，如果可以匹配到最后一个单词，说明可以划分，返回true
        但是这时递归栈很深，会出现超出时间限制的情况，此时需要剪枝。
        剪枝策略:
            在递归时，如果以当前位置被访问过，那么当前的递归就是多余的(因为前面已经判断过从当前位置
                    开始进行单词划分是不可行的，行的话直接返回true了，不会进行到这一步)
            所以可以用一个boolean数组标记是否从当前位置查找过，如果查找过就不用再去递归查找
        时间复杂度O(N ^ 2)
        空间复杂度O(N)   : 递归栈的最大深度（n为s的长度）
     */
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        if(n == 0 || wordDict.isEmpty()){
            return false
        }
        val visited = BooleanArray(n + 1)
        return bfs(0, n, visited, s, wordDict)
    }
    private fun bfs(start: Int, n: Int, visited: BooleanArray, s: String, wordDict: List<String>) : Boolean  {
        if(start == n){
            return true
        }
        for(word in wordDict){
            val nextIndex = word.length + start
            if( (nextIndex <= n ) && ((s.substring(start,  nextIndex)) == word)
                    && !visited[ nextIndex]){
                visited[ nextIndex] = true           //剪枝，做标记此位置已经被访问过，如果下次在遇到此位置直接跳过
                val res = bfs( nextIndex, n, visited, s, wordDict)
                if(res){
                    return true
                }
            }
        }
        return false
    }
    /*
    方法2. bfs
        和刚才dfs的思路一样，使用bfs的方式来实现
     */
    fun wordBreak1(s: String, wordDict: List<String>): Boolean {
        val queue: Queue<Int> = LinkedList()
        queue.add(0)
        val n = s.length
        val visited = BooleanArray(n + 1)       //剪枝的判断数组

        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val start = queue.poll()
                for (word in wordDict) {
                    val nextStart = start + word.length
                    if (nextStart > n || visited[nextStart]) {
                        continue
                    }
                    if (s.substring(start,nextStart) == word) {
                        if (nextStart == n) {
                            return true
                        }
                        queue.add(nextStart)
                        visited[nextStart] = true
                    }
                }
            }
        }
        return false
    }
}