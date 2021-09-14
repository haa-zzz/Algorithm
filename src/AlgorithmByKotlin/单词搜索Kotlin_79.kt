package AlgorithmByKotlin

class 单词搜索Kotlin_79 {
    /*
    给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
        同一个单元格内的字母不允许被重复使用。
     */
    /*
        dfs,从网格的每一个字母出发进行dfs，尝试与给定的单词匹配
        在每一次进行dfs时，对于当前位置来说，它有四种走法，向左，向右，向上，向下。
        此时可能在深搜过程中搜索到已经遇到的字母，对于这种情况是不允许的，所以我们需要定义一个visited数组用来判断
        某个单词是否已经访问过。
        深搜的终止条件：
            1.当前字母和word对于索引位置字母不相同，直接返回false
            2.当前字母和word对于索引位置字母相同，并且已经是word的最后一个单词了，说明找到了，返回true

        时间复杂度O(MN⋅3^l ) ：L是单词的长度，因为每次调用dfs时，除了第一次进入四个分支，其他最多只会进入3个分支(其中一个走过了)
                所以每一次dfs的时间复杂度为（3^l）
        空间复杂度：O(MN)
     */
    open fun exist(board: Array<CharArray>, word: String): Boolean {
        val n = board.size
        val m = board[0].size
        val visited = Array(n) { BooleanArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                val flag = dfs(board, visited, i, j, word, 0)
                if (flag) {
                    return true
                }
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, visited: Array<BooleanArray>, i: Int, j: Int, word: String, index: Int): Boolean {
        if (board[i][j] != word[index]) {
            return false
        } else if (index == word.length - 1) {
            return true
        }
        visited[i][j] = true
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        var result = false
        for (dir in directions) {
            val newI = i + dir[0]
            val newJ = j + dir[1]
            if (newI >= 0 && newJ >= 0 && newI < board.size && newJ < board[0].size) {
                if (!visited[newI][newJ]) {
                    val flag = dfs(board, visited, newI, newJ, word, index + 1)
                    if (flag) {
                        result = true
                        break
                    }
                }
            }
        }
        visited[i][j] = false
        return result
    }
}