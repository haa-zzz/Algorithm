package com.haa.algorithm.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
    你现在是棒球比赛记录员。
    给定一个字符串列表，每个字符串可以是以下四种类型之一：
    1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
    2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
    3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
    4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。

    每一轮的操作都是永久性的，可能会对前一轮和后一轮产生影响。
    你需要返回你在所有回合中得分的总和。

 */
/*
      分析：使用栈储存每轮的结果，分为四种情况处理，最后要在遍历一遍栈，吧栈中的每个数字相加
      时间复杂度O(N)
      空间复杂度O(N)
 */


public class 棒球比赛 {

    public static int calPoints(String[] ops) {
        int nums = 0;

        Deque<Integer> list = new ArrayDeque<>();

        for(int i = 0; i < ops.length; i++){

            if(ops[i].equals("+")){

                int num1 = list.pop();
                int num2 = list.peek();

                list.push(num1);            //吧出栈的重新入栈
                list.push(num1+num2);


            }else if(ops[i].equals("D")){
                list.push(list.peek()*2);

            }else if(ops[i].equals("C")){
                if( !list.isEmpty()){
                    list.pop();
                }
            }else{

                list.push(Integer.parseInt(ops[i]));           //是数字，直接入栈
            }
        }
        while ( !list.isEmpty()){                       //吧结果相加
            nums+=list.pop();
        }
        return nums;

    }
    public static void main(String[] args){
        String[] strings = new String[]{"5","2","C","D","+"};
        int s = calPoints(strings);
        System.out.println(s);
    }
}
