package com.haa.数组和字符串.数组和字符串Java;

/*
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

 */
/*
方法：双指针，一个指向头，一个指向尾，一次交换两个元素
时间复杂度 O(N)
空间复杂度O(1)
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int j = s.length-1;
        int i = 0;
        while(i<j){
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            j--;
            i++;
        }

    }

}
