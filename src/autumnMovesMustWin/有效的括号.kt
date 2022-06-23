package autumnMovesMustWin

import java.util.*
/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    力抠：20
 */
/**
    方法:用栈解题，如果是左括号直接入栈，如果遇到右括号，与栈顶元素比较看是否匹配
 */
fun isValid(s: String): Boolean {
    val n = s.length
    if (n % 2 == 1) return false
    val map = HashMap<Char, Char>()
    map[')'] = '('
    map['}'] = '{'
    map[']'] = '['
    val stack: Deque<Char> = ArrayDeque()
    s.forEach { c ->
        if (map.containsKey(c)) {
            if (stack.isEmpty() || stack.poll() != map[c]) {
                return false
            }
        } else {
            stack.push(c)
        }
    }
    return stack.isEmpty()
}
/**
 * java
 */
/*
public boolean isValid(String s) {
    int n = s.length();
    if (n % 2 == 1) return false;
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
    Deque<Character> deque = new ArrayDeque<>();
    for(Character ch : s.toCharArray()){
        if(map.containsKey(ch)){             //如果是右括号
            if( deque.isEmpty() ||  ( deque.poll() != map.get(ch) )  ){
                return false;
            }
        }else{
            deque.push(ch);           //如果是左括号
        }
    }
    return deque.isEmpty();
}*/
