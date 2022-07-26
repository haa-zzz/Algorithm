package 面试.常用数据结构;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class 求区间最小数乘区间和的最大值_1856 {
  /*
    给定一个数组，要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：区间中的最小数 * 区间所有数的和。
    数组中的元素都是非负数。
    输入两行，第一行n表示数组长度，第二行为数组序列。输出最大值。

    输入
    3
    6 2 1
    输出
    36
    解释：满足条件区间是[6] = 6 * 6 = 36;
   */
    /*
    使用前缀和，对数组做一遍预处理

    然后使用单调栈（单调递增）
        从左到右，求一遍每个元素右边第一个小于该元素的
        从右到左，求一遍每个元素左边第一个小于该元素的
    随后将元素下标在数组中，
    和前缀和配合使用，获得最终解
     */
  static class Solution {
      public int maxSumMinProduct(int[] nums) {
          int n = nums.length;
          // 数组前缀和
          long[] pre = new long[n];  //存储 0-i-1 的下表和
          pre[0] = 0 ;
          for (int i = 1; i <= n; i++) {
              pre[i] = pre[i - 1] + nums[i-1];
          }
          // 单递增调栈
          Deque<Integer> stack = new ArrayDeque<>();
          int[] rightLower = new int[n];     // 求元素右边第一个比其小的
          Arrays.fill(rightLower, n);  // 默认为n，即没发现
          for (int i = 0; i < n; i++) {
              while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                  int t = stack.pop();
                  rightLower[t] = i;
              }
              stack.push(i);
          }
          int[] leftLower = new int[n];   // 求元素左边第一个比其小的
         Arrays.fill(leftLower, -1);  // 默认为-1，即没发现
          for (int i = n - 1; i >= 0; i--) {
              while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                  int t = stack.pop();
                  leftLower[t] = i;
              }
              stack.push(i);
          }
          // 在前缀和及单调栈基础上，求最终解
          long ans = 0;
          for (int i = 0; i < n; i++) {
              int r =  rightLower[i];    //右边第一个小于这个当前元素的下标  比如1 9 8 10 5 当前元素是8 下标为4
              int l =  leftLower[i] + 1;    //左边第一个小于当前元素的下标 ，下标为0
              long sum = pre[r] - pre[l];   //求这个元素作为最小值的子序列和
              ans = Math.max(ans, sum * nums[i]);
          }
          long mod = (long) 1e9 + 7;
          return (int) (ans % mod);
      }
  }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumMinProduct(new int[]{1,2,3,2}));
    }
}
