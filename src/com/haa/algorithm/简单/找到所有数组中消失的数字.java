package com.haa.algorithm.简单;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    /*
    给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

    找到所有在 [1, n] 范围之间没有出现在数组中的数字。

    您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     */
    /*
    分析：如果不考虑时间复杂度，可以吧数组中的每个元素用hash表存储，最后从1到n遍历,吧没在hash表中元素返回即可
    这时做法的时间复杂度为O(N),空间复杂度为O(N)

    为了在时间复杂度O(1)解题,可以用给定的数组nums替代hash表，思路如下：

    1.将数组元素对应为索引的位置加n(注意：因为有的数字重复，所以在计算对应索引位置时要进行取模运算)
    2.遍历加n后的数组，若数组元素值小于等于n，则说明数组下标值不存在，即消失的数字
    时间复杂度O(N)
    空间复杂度O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        for(int num : nums){
            int x = (num-1)%n;
            nums[x]  += n;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(nums[i] <= n){
                list.add(i+1);
            }
        }
        return list;
    }
}
