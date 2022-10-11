package com.haa.深搜广搜;

public class 打印从1到最大的n位数 {

    /*
    输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     */

    public static void main(String[] args) {
        System.out.println(printNumbers(3));
    }
    static StringBuilder res;
    static int n1 = 0;
    static char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int[] arr;
    static int index = 0;
    public static int[] printNumbers(int n) {
        n1 = n;
        res = new StringBuilder();  // 数字字符串集
        num = new char[n];  // 定义长度为 n 的字符列表
        dfs(0);  // 开启全排列递归
        arr = new int[(int)Math.pow(10,n)-1];
        return arr;
    }
    static void dfs(int x) {
        if(x == n1) { // 终止条件：已固定完所有位
            arr[index++] = getNumber(String.valueOf(num));  // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }
    static int getNumber(String str) {
        return Integer.parseInt(str);
    }
}
