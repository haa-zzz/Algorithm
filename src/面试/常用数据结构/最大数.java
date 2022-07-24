package 面试.常用数据结构;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大数 {
    /*
    给定一个数n如23121; 给定一组数字a如[2 4 9]求由a中元素组成的小于n的最大数
     */
    /*
    回溯：
    构建一个和给定数位数相同的数字，从左到右填充每一位数，对于这个数字上的每一位，都尽可能让这个数字大.
    一般情况下，最大的数自然是数字n的这个位数temp，如果给定数中没有这个数temp，就需要取比这个数稍微小的数，
    如果取得了这个稍小的数，那么从这一位开始，接下来的所有位都要取给定的数字中最大值。
    如果也不存在比这个位数temp小的数，需要向上回溯一位，上一位数变小，然后从这一位开始一直取最大数字。

    注意边界情况：
        52222  5 ->   5555
        55555  5,9 -> 9999
     */
    static class Solution {
        int ans;
        public int maxNumber(int n, int[] arr) {
            char[] numbers = String.valueOf(n).toCharArray();
            dfs(numbers, arr, 0, 0, false);
            return ans;
        }
        private boolean dfs(char[] numbers, int[] arr, int index, int maxValue, boolean pass) {
            if(index == numbers.length) {   //如果numbers == maxValue 还要回溯 比如55555，5这种
               if(String.valueOf(maxValue).equals(String.valueOf(numbers)))
                   return false;
               ans = maxValue;  //否则就说明找到了
               return true;
            }
            if(pass) {  //pass为true,只有最高位没有数，或者上一位数小于对应n中的值,直接取最大直接就好了
                return dfs(numbers, arr, index+1, maxValue * 10 +arr[arr.length-1], true);
            } else {
                int value = numbers[index] - '0';
                for(int i = arr.length-1; i >= 0; i--) { //找到与这一位相比 取相等的或者小于中最大的一位
                    if(value == arr[i]) { //如果相等，那么直接拿这个数，判断下一位.
                        if( dfs(numbers, arr, index+1, maxValue*10+arr[i], false) )
                            return true;
                    } else if(value > arr[i]) { //如果value大于arr[i],放入这一位后，后面的都放最大值.
                        if( dfs(numbers, arr, index+1, maxValue*10+arr[i], true) )
                            return true;
                    }
                }
                if(index != 0) return false;   //value < arr中所有的数，回溯。
                return dfs(numbers, arr, index+1, maxValue, true); //index==0 说明要少一位，直接回溯，后面都取最大值
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNumber(23121, new int[]{2,4,9}));
    }
}
