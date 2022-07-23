package com.haa.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 栈的压入弹出序列_946 {
    /*
    输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
    但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
    力抠：946
     */

    /**
     * 给定压入序列和弹出序列后，压入 / 弹出操作的顺序（即排列）是 唯一确定 的。
     *
     * 借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。
     * 入栈操作： 按照压栈序列的顺序执行。
     * 出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
     *
     * 时间复杂度： O(N)
     * 空间复杂度： O(N)
     *
     */
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            LinkedList<Integer> stack = new LinkedList<>();
            int i = 0;
            for(int push: pushed) {
                stack.push(push);
                while (!stack.isEmpty() && stack.peek() == popped[i]) {
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
