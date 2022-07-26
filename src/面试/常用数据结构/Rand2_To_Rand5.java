package 面试.常用数据结构;

import java.util.Random;

public class Rand2_To_Rand5 {
    class Solution {
        private int rand2() {
            Random random = new Random(1);
            return random.nextDouble() > 0.5 ? 1:0;
        }
        public int rand5() {
            int res = 0;
            do {
                res = (rand2() << 2) + (rand2() << 1) + rand2();
            }while(res >= 5);
            return res;
        }

    }
}
