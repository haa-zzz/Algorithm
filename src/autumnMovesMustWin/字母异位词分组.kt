package autumnMovesMustWin

import java.util.*
/*
   给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串

    力抠： 49
    */
/**
方法.排序+hash表存储
 以字符串为key，字母异位字符串集位value构建hash表，因为异位字符串按字典顺序排序后的字符串是相同的，
 所以遍历每一个字符串，先对字符串排序，如果排序后的字符串对应的key在hash表中存在，就拿到对应的value,不存在，就新建一个对应的集合。把原字符串加入到集合中。
 最后更新hash表

 时间复杂度O(n K log K),n是字符串数组的长度，k是单个字符串对应的最大长度
 空间复杂度 O(nK )
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, List<String>>()
    strs.forEach {
        val ch = it.toCharArray()
        Arrays.sort(ch)
        val key = String(ch)
        val path: MutableList<String> = map.getOrDefault(key, ArrayList()).toMutableList()
        path.add(it)
        map[key] = path
    }
    return map.values.toList()
}
