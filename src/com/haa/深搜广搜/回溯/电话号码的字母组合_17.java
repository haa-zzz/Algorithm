package com.haa.深搜广搜.回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合_17 {
    /*
    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    
    提示：
    0 <= digits.length <= 4
    digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    /*
    分析：回溯
       1.首先要用Map存储每一种电话号码和对于的字母，之后采用回溯的方法解题。
       2.用index作为状态变量，表示当前要选的是第index+1个字母。用path保存每一趟的结果，对于当前的状态，首先拿到map
       中对于的字母集，遍历字母集，拿到一个字母加入到path中。然后递归的去考虑下一个状态。
       3.当index == digits.length()时，表示对于digits的每个对应数字，我们都拿到了一个对应的字母，此时结束，把结果加入结果集ans
       4.回溯部分，一趟递归结果时，我们要回退一部，需要删除path保存的最后一个字母

       时间复杂度O(3 ^ m * 4 ^ n)
       空间复杂度O( m+n )
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if( digits.length() == 0 ){
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack( 0, digits , new StringBuilder(), ans , map);
        return ans;
    }
    private void  backtrack(int index , String digits, StringBuilder path, List<String> ans ,
                            Map<Character, String> map){
        if( index == digits.length() ){
            ans.add(path.toString());
        }else{
            char digit = digits.charAt(index);
            String str = map.get(digit);        //拿到当前状态对于的字母集
            for(int i = 0; i < str.length(); i++){
                path.append(str.charAt(i));     //选择一个字母加入path
                backtrack(index + 1, digits, path, ans , map);  //递归的去考虑下一状态
                path.deleteCharAt(index);   //回溯时删除path的最后一个字符
            }
        }
    }
}
