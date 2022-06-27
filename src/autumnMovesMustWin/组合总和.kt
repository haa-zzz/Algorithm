package autumnMovesMustWin


/*
  给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
  candidates 中的数字可以无限制重复被选取。
  说明：
  所有数字（包括 target）都是正整数。
  解集不能包含重复的组合。
  力抠：39
   */
/**
分析：回溯问题，
    1.分析递归过程
        对于candidates = [2, 3, 6, 7]，target = 7。
        如果选择了2，在找到组合总和为 7 - 2 = 5 的所有组合，再在之前加上 2 ，就是 7 的所有组合；
        同理考虑 3，如果找到了组合总和为 7 - 3 = 4 的所有组合，再在之前加上 3 ，就是 7 的所有组合，依次这样找下去。
    2.找结束条件
        当target <= 0 时结束
            当target == 0 时把这条路径加入集合
    3.找选择列表
        用一个参数i来表示当前选择列表的起始位置，如果上一层路径添加了candidates[i]，那么下一层应该从i开始，
        这样做保证了一个路径中可以有重复元素，也保证了不存在重复的路径。

    复杂度分析：
        时间复杂度O(S)       其中 S 为所有可行解的长度之和
        空间复杂度O(target)  空间栈的深度最坏情况需要递归O(target)层

 */
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    combinationSumSearch(candidates, target, 0,0, ArrayList(), ans)
    return ans
}

fun combinationSumSearch(candidates: IntArray, target: Int, index: Int,
                   sum: Int, path: MutableList<Int>, ans: MutableList<List<Int>>) {
    if(sum == target) {
        ans.add(ArrayList(path))        //注意这里要new一个新的
    } else if(sum < target) {
        for(i in index until candidates.size) {
            path.add(candidates[i])
            combinationSumSearch(candidates, target, i,sum+candidates[i], path, ans)
            path.removeAt(path.size - 1)
        }
    }
}

/**
 * 排序+剪纸 进行优化
 *
 * 如果数组是一个有序的数组，在递归过程中，遇到和比target大的就可以直接返回了
 */


fun combinationSumByMethodTWO(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    candidates.sort()
    combinationSumSearchByMethodTWO(candidates, target, 0,0, ArrayList(), ans)
    return ans
}

fun combinationSumSearchByMethodTWO(candidates: IntArray, target: Int, index: Int,
                         sum: Int, path: MutableList<Int>, ans: MutableList<List<Int>>) {
    if(sum == target) {
        ans.add(ArrayList(path))        //注意这里要new一个新的
    } else if(sum < target) {
        for(i in index until candidates.size) {
            if(sum + candidates[i] > target) {
                break
            }
            path.add(candidates[i])
            combinationSumSearchByMethodTWO(candidates, target, i,sum+candidates[i], path, ans)
            path.removeAt(path.size - 1)
        }
    }
}