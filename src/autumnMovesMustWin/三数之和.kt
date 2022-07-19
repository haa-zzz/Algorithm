package autumnMovesMustWin

/*
   给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
   注意：答案中不可以包含重复的三元组。
   力抠：15
    */
/*
方法：排序 + 双指针
    先对数组进行排序，排序后固定一个数 nums[i]，
    再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
    注意：
    1. 如果nus[i] > 0, 三数之和必然大于0，结束循环
    2. 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
    3. 对于left，right指针，应该和2同理，有重复跳过

    时间复杂度O( N ^ 2 )
    空间复杂度O( logN ) ：额外的排序的空间复杂度为 O(logN)
 */

fun threeSum(nums: IntArray): List<List<Int>> {
    val n = nums.size
    if(n < 3) { return emptyList() }
    val ans = mutableListOf<List<Int>>()
    nums.sort()
    for(i in 0..n-3) {
        if(nums[i] > 0) { break }
        if(i > 0 && nums[i] == nums[i-1]) { continue }
        var left = i+1
        var right = n-1
        while(left < right) {
            if(left > i+1 && nums[left] == nums[left-1]) {
                left++
                continue
            }
            if(right < n-1 && nums[right] == nums[right+1]) {
                right--
                continue
            }
            val sum = nums[i] + nums[left] + nums[right]
            when {
                sum == 0 -> {
                    ans.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                }
                sum < 0 -> {
                    left++
                }
                else -> {
                    right--
                }
            }
        }

    }
    return ans
}
/**
 * java
 */
/*
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList();
    int n = nums.length;
    if(n < 3){
        return ans;
    }
    Arrays.sort(nums);
    for(int i = 0; i < n; i++){
        if(nums[i] > 0){
            break;
        }
        if(i > 0 && nums[i] == nums[i-1]){
            continue;           //去重
        }
        int left = i+1, right = n-1;
        while(left < right){
            if(left > i+1 && nums[left] == nums[left-1]) {
                left++;
                continue;
            }
            if(right < n-1 && nums[right] == nums[right+1]) {
                right--;
                continue;
            }
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
            }
            else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
    }
    return ans;
}*/
