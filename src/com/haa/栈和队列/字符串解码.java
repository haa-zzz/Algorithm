package com.haa.栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 字符串解码 {
    /*
    给定一个经过编码的字符串，返回它解码后的字符串。

    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
        示例 1：

    输入：s = "3[a]2[bc]"
    输出："aaabcbc"

     */
    /*
    方法1.这个题需要从内向外生成与拼接字符串，这与栈的先入后出特性对应。可以使用栈来解题
    分析：
        使用两个栈一个是前面的数字栈，一个是 完成拼接后的字符串栈，遍历字符串，主要分四种情况：
            当 c 为数字时，将数字字符转化为数字  number，用于后续倍数计算；
            当 c 为字母时，在 res 尾部添加 c；
            当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置0：
            当 c 为 ] 时，stack 出栈，拼接字符串
    时间复杂度 O(N)
    空间复杂度 O(N)
     */
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();
        int number = 0;

        Deque<Integer> stack_number = new ArrayDeque<>();       //数字栈
        Deque<String> stack_res = new ArrayDeque<>();           //字符串栈
        for(Character c : s.toCharArray()){
            if(c == '['){
                stack_number.push(number);
                stack_res.push(res.toString());             //先把上次拼接好的字符串和前面的乘数入栈做记录
                number = 0;                                 //清零用于下次
                res = new StringBuilder();
            }else if (c == ']'){
                StringBuilder tmp = new StringBuilder();
                int multi = stack_number.pop();
                for(int i = 0; i < multi; i++)
                    tmp.append(res);
                res = new StringBuilder(stack_res.pop()+ tmp);
            }
            else if(c >= '0' && c <= '9'){
                number = number*10+Integer.parseInt(c+"");
            }
            else {
                res.append(c);
            }

        }
        return res.toString();
    }
    /*
    方法2.递归
    总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：

    当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
    当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
    遍历完毕后返回 res。

    复杂度分析：
    时间复杂度 O(N)
    空间复杂度 O(N)

     */
    public String decodeString1(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')        //数字
                multi = multi * 10 + Integer.parseInt(s.charAt(i)+"");

            else if(s.charAt(i) == '[') {                       //遇到‘’[''，开启下一个递归
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }




}
