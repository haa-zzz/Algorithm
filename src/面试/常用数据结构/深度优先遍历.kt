package 面试.常用数据结构

/**
 * DFS（深度优先搜索）
 *
 * 深度优先搜索的步骤分为 1.递归下去 2.回溯上来。顾名思义，深度优先，则是以深度为准则，先一条路走到底，直到达到目标。这里称之为递归下去。
    否则既没有达到目标又无路可走了，那么则退回到上一步的状态，走其他路。这便是回溯上来。

 典型的例子：复原IP
    方法：深搜+回溯
    深搜的方法，每次先找第一个整数，从第一个整数开始向下深搜，如果符合条件，添加这个IP,注意深搜的最后需要回溯。
 */



fun restoreIpAddresses(s: String): List<String> {
    val res: MutableList<String> = mutableListOf()
    dfs(res, StringBuilder(s), 0, 0)
    return res
}
//用于判断这个字符串是不是符合条件的一个整数
fun isValid(s: String): Boolean {
    //必须要满足 s不为空 && 个数小于4 && 数值 <= 255 && 超过一位首位不能为0
    return s.isNotEmpty() && s.length < 4 && (s.length <= 1 || s[0] != '0' && s.toInt() <= 255)
}

private fun dfs(res: MutableList<String>, sb: StringBuilder, startIndex: Int, nodeCount: Int) {
    //现在整数的个数已经有三个了，如果说最后一个也满足的话，那么就说明是一个正确格式的IP,直接把它添加到集合中去，否则直接return回溯寻找下一个
    if (nodeCount == 3) {
        if (isValid(sb.substring(startIndex)))
            res.add(sb.toString())
        return
    }
    //整数 要么是 1位，要莫是2位，要莫是3位，所以只需要遍历找到到第一个整数，在递归的去找后面的整数就好了。
    var i = startIndex
    while (i < sb.length && i < startIndex + 3) {
        val subIp = sb.substring(startIndex, i + 1) //寻找从 startIndex 到 i+1 出发是否可以组成一组合适的IP地址
        if (isValid(subIp)) {     //如果[startIndex , i+1)是满足要求的一个整数，那么就在它后面添加'.',并递归找下一个满足要求的整数
            sb.insert(i + 1, ".")
            dfs(res, sb, i + 2, nodeCount + 1) //递归找下一个整数
            sb.deleteCharAt(i + 1) //回溯过程，删除我们添加的“.”
        }
        i++
    }
}


class Solution {
    fun validIPAddress(queryIP: String): String {
        val list: List<String>
        if(queryIP.contains(".")) {
            list = queryIP.split('.')
            if(list.size != 4) return "Neither"
            list.forEach {
                if(!isSubIpV4(it)){
                    return "Neither"
                }
            }
            return "IPv4"
        } else if(queryIP.contains(":")) {
            list = queryIP.split(':')
            if(list.size != 8) return "Neither"
            list.forEach {
                if(!isSubIpV6(it)){
                    return "Neither"
                }
            }
            return "IPv6"
        }
        return "Neither"

    }
    fun isSubIpV4(s: String) : Boolean{
        return s.isNotEmpty() && s.length < 4 && (s.length <= 1 || s[0] != '0' && s.toInt() <= 255)
    }
    fun isSubIpV6(s: String) : Boolean{
        if(s.isEmpty() || s.length > 4) {
            return false
        }
        s.forEach {
            if( (it < '0' || it > '9') && (it < 'a' || it > 'z') && (it < 'A' || it > 'Z') ) {
                return false
            }
        }
        return true
    }
}