package 面试.常用数据结构;

public class _36进制加法 {
    /*
    36进制由0-9，a-z，共36个字符表示。
    要求按照加法规则计算出任意两个36进制正整数的和，如1b + 2x = 48 （解释：47+105=152）
    要求：不允许使用先将36进制数字整体转为10进制，相加后再转回为36进制的做法
     */

    static class Solution {

        public String add36String(String num1, String nums2) {
            int i = num1.length()-1;
            int j = nums2.length()-1;
            int number = 0;
            StringBuilder ans = new StringBuilder();
            while(i >= 0 || j >= 0 || number > 0) {
                int x = (i >=0 )? get36Int(num1.charAt(i)) : 0;
                int y = (j >= 0)? get36Int(nums2.charAt(j)) : 0;
                int temp = x + y + number;
                ans.append(get36Char(temp % 36));
                number = temp/36;
                i--;
                j--;
            }
            return ans.reverse().toString();
        }
        private char get36Char(int number) {
            if(0 <= number && number <= 9)
                return (char)('0' + number);
            return (char) ('a' + (number - 10));
        }
        private int get36Int(char ch) {
            if('0' <= ch && ch <= '9')
                return ch - '0';
            return ch - 'a' + 10;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add36String("1b","2x"));
    }

}
