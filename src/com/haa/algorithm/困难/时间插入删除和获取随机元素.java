package com.haa.algorithm.困难;

import java.util.*;

public class 时间插入删除和获取随机元素 {
    /*
    设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

    注意: 允许出现重复元素。

    insert(val)：向集合中插入元素 val。
    remove(val)：当 val 存在时，从集合中移除一个 val。
    getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

     */
    /*
    单用List,可以通过，但是时间复杂度超过O(1)
            注：list只有在删除尾元素时能够实现O1
     */
    static  class RandomizedCollection {
        private final List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list = new ArrayList<>();
        }
        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if(list.contains(val)){
                list.add(val);
                return false;
            }
            list.add(val);
            return true;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            return list.remove( (Integer)val);
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            Random random = new Random();
            return list.get( random.nextInt(list.size()) );
        }
    }
    /*
            O(1)阶完成的方法
                LIst,HashMap配合使用
     */
    class RandomizedCollection1 {
          List<Integer> list;
          Map<Integer, Set<Integer>> map;
        /** Initialize your data structure here. */
        public RandomizedCollection1() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }
        public boolean insert(int val) {
            list.add(val);
            Set<Integer> set = map.getOrDefault(val,new HashSet<>());
            set.add(list.size()-1);
            map.put(val,set);
            return set.size()==1;
        }
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Iterator<Integer> iterator = map.get(val).iterator();
            int i = iterator.next();
            int lastNum = list.get(list.size()-1);
            list.set(i,lastNum);
            map.get(val).remove(i);
            map.get(lastNum).remove(list.size()-1);
            if(i < list.size()-1){
                map.get(lastNum).add(i);
            }
            if(map.get(val).size()==0){
                map.remove(val);
            }
            list.remove(list.size()-1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {

            return list.get( (int) (Math.random()*list.size() ) );
        }
    }

}
