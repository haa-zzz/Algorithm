package autumnMovesMustWin

import kotlin.math.min

/*
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
    力抠：4
*/

/**
  方法1: 遍历，因为两个数组都是有序的，可以通过遍历的方法来找到中位数。
  对奇数或偶数寻找中位数的处理：
   如果 len为奇数，mid_index = len/2
   如果 len是偶数，mid_index = len/2, len/2 - 1
  所以为了统一处理，可以用两个变量来更新中间值，cur表示当前值，pre存储上一个cur值,当cur走到len/2时，pre的值就是 len/2-1位置对应的值

  时间复杂度O(m+n)
  空间复杂度O(1)
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var index1 = 0
    var index2 = 0
    var pre = 0
    var cur = 0
    val len = nums1.size + nums2.size
    for(i in 0..len/2) {
        pre = cur
        if(index1 < nums1.size && (index2 == nums2.size || nums1[index1] < nums2[index2])) {
            cur = nums1[index1]
            index1++
        } else {
            cur = nums2[index2]
            index2++
        }
    }
    return  if (len and 1 == 0) (pre+cur).toDouble()/2 else cur.toDouble()
}

/**
 * java
 */
/*
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int len = m + n;
    int pre = -1, cur = -1;    // 初始化
    int aStart = 0, bStart = 0;     //迭代指针

    for (int i = 0; i <= len / 2; i++) {
        pre = cur;
        if (aStart < m && ( bStart >= n || nums1[aStart] < nums2[bStart]) ) {
            cur = nums1[aStart++];
        } else {
            cur = nums2[bStart++];
        }
    }

    if( (len & 1) == 0 )        //如果是偶数
    return (pre + cur) / 2.0;
    else
    return cur;
}

 */
/**
  方法2: 二分查找
       这道题可以通过寻找第k小的数来解决
       求第k小的数：
           可以每次循环排除掉 k/2 个数。每次比较两个数组的第k/2个数字，如果那个小，就表明该数组的前 k/2 个数字都不是第k小的数，可以直接排除
           如：  A[1] ，A[2] ，A[3]，A[k/2] ... ，B[1]，B[2]，B[3]，B[k/2] ... ，
               如果 A[k/2]<B[k/2] ，那么A[1]，A[2]，A[3]，A[k/2]都不可能是第 k 小的数字。
          所以我们采用递归的思路，为了防止数组长度小于 k/2，所以每次比较 min(k/2，len(数组) 对应的数字，
          把小的那个对应的数组的数字排除，将两个新数组进入递归，并且 k 要减去排除的数字的个数。
         递归出口就是当 k=1 或者其中一个数字长度是 0 了。

  时间复杂度O( log(m+n) )
  空间复杂度O( 1 )
 */

fun findMedianSortedArraysByMethod2(nums1: IntArray, nums2: IntArray): Double {
    val n = nums1.size + nums2.size
    return (getKth(nums1,0, nums2, 0, (n+1)/2)
            + getKth(nums1,0, nums2, 0, (n+2)/2)).toDouble() / 2
}

private fun getKth(nums1: IntArray, start1: Int, nums2: IntArray, start2: Int, k: Int) : Int{
    val len1 = nums1.size - start1
    val len2 = nums2.size - start2
    if (len1 == 0) return nums2[start2 + k - 1]     //有一个数组为0就可以直接返回了
    if (len2 == 0) return nums1[start1 + k -1]

    if (k == 1) return min(nums1[start1], nums2[start2])   //递归出口

    val i = start1 + min(len1, k/2) - 1
    val j = start2 + min(len2, k/2) - 1

    return if (nums1[i] < nums2[j]) {
        getKth(nums1, i+1, nums2, start2, k - (i - start1 + 1))
    } else {
        getKth(nums1, start1, nums2, j+1, k - (j - start2 + 1))
    }

}

/**
 * java
 */
/*
public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int pre = (n + m + 1) / 2;
    int cur = (n + m + 2) / 2;
    //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
    return ( getKth(nums1, 0, n-1, nums2, 0, m-1, pre)
            + getKth(nums1, 0, n-1, nums2, 0, m-1, cur) ) * 0.5;
}
private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){

    int len1 = end1 - start1 + 1;
    int len2 = end2 - start2 + 1;

    //递归出口
    if(len1 == 0) return nums2[start2+k-1];
    if(len2 == 0) return nums1[start1+k-1];

    if(k == 1){
        return Math.min( nums1[start1], nums2[start2] );
    }
    int i = start1 + Math.min( len1, k/2 ) -1;
    int j = start2 + Math.min( len2, k/2 ) -1;
    //递归
    if( nums1[i] < nums2[j] ){
        return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1 ) ) ;
    }else{
        return getKth(nums1, start1, end1, nums2, j + 1 , end2, k - (j - start2 + 1 ) );
    }
}
 */