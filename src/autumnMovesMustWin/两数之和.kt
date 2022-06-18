package autumnMovesMustWin

/*
    给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    力扣1
 */

/**
 * 不能排序，因为要返回的是下标
 * 方法一: 暴力法 O(n^2)
 * 方法二:哈希表 时间O(n) 空间O(n)
 *      分析：哈希表不会存储重复，我们只要边添加边判断表中是否存在 target-x
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (map.containsKey(target - nums[i])) {
            return intArrayOf(i, map[target - nums[i]] ?: -1)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}

/**
 * java版
 */
/*
public class Solution {
    方法一:暴力法
    方法二:哈希表 分析：哈希表不会存储重复，我们只要边添加边判断表中是否存在 target-x

    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
 */
