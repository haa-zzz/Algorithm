package autumnMovesMustWin

import java.lang.StringBuilder

/*
   给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
   给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    力抠：17
 */
fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }
    val map = HashMap<Char,String>()
    map['2'] = "abc"
    map['3'] = "def"
    map['4'] = "ghi"
    map['5'] = "jkl"
    map['6'] = "mno"
    map['7'] = "pqrs"
    map['8'] = "tuv"
    map['9'] = "wxyz"
    val ans = mutableListOf<String>()
    search(digits, 0, StringBuilder(), map, ans)
    return ans
}

fun search(digits: String, index: Int, str: StringBuilder, map: HashMap<Char, String>, ans: MutableList<String>) {
    if(index == digits.length-1) {
        ans.add(str.toString())
    } else {
        map[digits[index]]?.forEach { c ->
            str.append(c)
            search(digits, index+1, str, map, ans)
            str.deleteCharAt(index)
        }
    }
}

/**
 * java
 */
/*public List<String> letterCombinations(String digits) {
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
}*/
