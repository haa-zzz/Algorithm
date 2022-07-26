package 面试.常用数据结构;

import java.math.BigDecimal;

public class 根号2小数点后面10000位 {

    static class Solution {
        /*
        假设给的数字为n, 可以设置左边界为0, 右边界为n,
        取mid = (0 + n) / 2, 如果mid2 小于n, 令左边界为mid, 否则有边界为mid,
        终结循环的条件是左右边界的差小于精度的阈值(right - left < threshold)
         */
        double getSqrt(int n, double threshold) {
            double left = 0, right = n;
            while ( right - left > threshold){
                double mid = (left + right) / 2;
                if (mid * mid == n) return mid;
                else if (mid * mid < n) left = mid;
                else right = mid;
            }
            return left;
        }

    }
}
