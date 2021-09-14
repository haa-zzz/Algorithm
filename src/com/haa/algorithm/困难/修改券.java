package com.haa.algorithm.困难;

import java.util.Arrays;

public class 修改券 {
    /*
     一共有n个人每个人抽到一个初始序号a[i],如果某个人的序号是有某个数字的平方，
     就会获奖。现在使用一些修改券，使用修改券后可以使自己的序号加一或者减一。
     现在求如果想让一半人获奖，至少需要多少张修改券？
      */
    /*
     分析：对于a[i]来说，记int sqrt = (int)Math.sqrt(a[i]);
        使用的最少的修改劵是 a[i]-sqrt * sqrt , 或者 (sqrt+1) * (sqrt+1) -a[i]

       所以我们就可以遍历修改每一个a[i]的值让它变为它使用的最少修改劵

       最后排序，取前一半的相加即可
     */
    public int theNumberOfVolumes(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++){
            int k = a[i];
            int sqrt = (int)Math.sqrt(k);
            a[i] = Math.min((k - sqrt * sqrt),(sqrt+1)*(sqrt+1) - k);
        }
        Arrays.sort(a);
        int sum = 0;
        for(int i = 0; i < (n+1)/2; i++){
            sum+=a[i];
        }

        return sum;
    }
}
