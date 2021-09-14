package com.haa.数组和字符串.数组和字符串Java;

import java.util.*;

public class 反转字符串里的单词 {

    /*
    给定一个字符串，逐个翻转字符串中的每个单词。

说明：

无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 2：

输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     */
    /*
    分析：方法一.使用StringBuilder进行反转和拼接，可以从前到后进行遍历，最后需要反转两次，也可从后到前遍历，只需盘转一次
        注意：空格的处理，尤其是最后一个空格
     */

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for(char c : s.toCharArray()){
            if(c == ' '){
                sb.append(new StringBuilder(str).reverse());
                if(!str.equals("")){
                    sb.append(' ');
                    str ="";
                }
            }else{
                str+=c;
            }
        }
        if(str.equals("")){         //当最后以空格结尾时，在上面的代码我们多添加了一个空格，需要去除
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(new StringBuilder(str).reverse());
        }
        return sb.reverse().toString();
    }
    /*
    方法2.使用正则表达式
        字符串的分割s.split("\\s*"),反转，拼接

       String[]    split(String regex)
            将此字符串分割为给定的 regular expression的匹配。

     List<String> strings = new LinkedList<>();
     strings.add("Java");strings.add("is");
     strings.add("cool");
     String message = String.join(" ", strings);
     //message returned is: "Java is cool"
     */
    public static String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s*"));

        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
    /*
    private void setCountdown() throws ParseException {

        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long endTime = Objects.requireNonNull(simpleDateFormat.parse(sign.getEndTime())).getTime();
        long nowTime = new Date().getTime();
        long millisUntilFinished = endTime-nowTime;
        // CountDownTimer 类实现倒计时功能
        CountDownTimer countDownTimer = new CountDownTimer(millisUntilFinished,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                long days = millisUntilFinished / (1000 * 60 * 60 * 24);
                long hours = (millisUntilFinished-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);
                long minutes = (millisUntilFinished-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
                long second = (millisUntilFinished-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)
                        -minutes*1000*60)/(1000);
                String time = hours+":"+minutes+":"+second;
                @SuppressLint("SimpleDateFormat")
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = null;
                try {
                    date = simpleDateFormat.parse(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                assert date != null;
                String Countdown = simpleDateFormat.format(date);

                if(days!=0){
                    SOGCountdown.setText(days+"天 "+Countdown);
                }
                else
                    SOGCountdown.setText(Countdown);
            }
            @Override
            public void onFinish() {
                SOnGoing.setVisibility(View.GONE);
                UnFinish.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();
    }
    */


}
