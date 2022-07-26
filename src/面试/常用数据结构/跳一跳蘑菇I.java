package 面试.常用数据结构;

public class 跳一跳蘑菇I {
    /*
    跳台阶 一共n节台阶一次可以跳任意节，每跳一节消耗一点体力，起始体力为m，每节台阶上都有一个蘑菇，
    当跳到一节台阶上就会吃掉这个台阶上的蘑菇，蘑菇的效果可能是增加体力也可能是减少体力，
    由一个长度为n的数组array代表每一节上的蘑菇的效果（正数为增加体力， 负数为减少体力）
    求到达最后的台阶时的最大体力值为多少（如果无法到达最后一节则返回-1）
     */

    /*
    贪心：在能力允许的范围内跳所有正数点，最后就是最大的.
     */
    static class Solution{
        int jumpByWeight(int n, int m, int[] arr) {
            int ans = m;        //维护最大体力
            for(int i = 0; i < n; i++) {
                ans--;  //不管当前体力值是正是负，主要越过这个台阶，就要减少一个体力值
                if(ans < 0) {   //只要在跳的过程中发现体力不够了，就直接返回
                    return -1;
                }
                if(arr[i] > 0) {    //只要是正的体力，就可以吃它
                    ans +=  arr[i];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jumpByWeight(7,4,new int[]{3,-20,-20,-20,-20,-20,7}));
    }
}
