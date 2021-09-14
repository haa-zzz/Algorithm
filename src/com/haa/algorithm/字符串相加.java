package com.haa.algorithm;

public class 字符串相加 {
    public String addStrings(String num1, String num2) {
        if(num1.length() < num2.length()){
            return addStrings(num2,num1);
        }
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(int k = num1.length()-1;k>=0; k--){
            if(num2.length()<k)
                sb.append(num1.charAt(k));
            else{
                int m = Integer.parseInt(num1.charAt(k)+"")+
                        Integer.parseInt(num2.charAt(k)+"");
                sb.append(m%10+n);
                n = m/10;
            }
        }
        if(n!=0)
            sb.append(1);
        return sb.reverse().toString();
    }
}
