package com.haa.algorithm.中等;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class 随机数索引_398 {

    class Solution {
        private HashMap<Integer, List<Integer>> map;
        private Random random;
        public Solution(int[] nums) {
            map = new HashMap();
            random = new Random();
            for (int i = 0;  i < nums.length;  i++) {
                map.putIfAbsent(nums[i], new ArrayList<Integer>());
                map.get(nums[i]).add(i);
            }

        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }
}
