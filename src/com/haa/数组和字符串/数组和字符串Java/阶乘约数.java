package com.haa.数组和字符串.数组和字符串Java;

import java.util.*;

public class 阶乘约数 {
    private static int[] questionOne(int number) {
        number = number < 0 ? -number : number;
        int[] approximates = new int[8];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j++) {
                if (index < 8) {
                    approximates[index++] = i * j;
                } else {
                    break;
                }
            }
        }

        return Arrays.copyOf(approximates, index);
    }

    private static int[] questionTwo(int[] array) {
        if (array.length < 1) {
            return null;
        }

        int i = 0;
        if (array.length < 4) {
            int[] newArray = new int[array.length - 1];
            for (int j = array.length - 2; j >= 0; j--) {
                newArray[i++] = array[j];
            }
            return newArray;
        } else {
            return new int[]{array[2], array[1], array[0]};
        }
    }

    private static int questionThree(int[] array) {

        if (array.length == 0) {
            return 0;
        }
        int i = 1;
        int index;
        while ((index = 25 / i) > array.length) {
            i++;
        }

        return array[index - 2];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(questionThree(Objects.requireNonNull(questionTwo(questionOne(number)))));
    }

}
