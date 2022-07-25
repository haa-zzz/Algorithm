package 面试.常用数据结构;

import java.util.BitSet;
import java.util.Random;

public class 海量数据 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 22, 0, 3, 64};
        BitSet bitSet = new BitSet(6);
        //将数组内容组bitmap
        for (int i = 0; i < array.length; i++) {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
    }

    static class BitmapTest {

        private static final int CAPACITY = 1000000000; //数据容量

        // 定义一个byte数组缓存所有的数据
        private final byte[] dataBytes = new byte[1 << 29];

        public static void main(String[] args) {
            BitmapTest ms = new BitmapTest();

            byte[] bytes = null;

            Random random = new Random();
            for (int i = 0; i < CAPACITY; i++) {
                int num = random.nextInt();
                System.out.println("读取了第 " + (i + 1) + "\t个数: " + num);
                bytes = ms.splitBigData(num);
            }
            System.out.println();
            ms.output(bytes);
        }

        /**
         * 读取数据，并将对应数数据的 到对应的bit中，并返回byte数组
         * @param num 读取的数据
         * @return byte数组  dataBytes
         */
        private byte[] splitBigData(int num) {

            //获取num整型数据对应的非负数，因为整型数num有正有负，因此这里加上了2^31将其变为一个非负数
            long bitIndex = num + (1L << 31);
            int index = (int) (bitIndex / 8);         //获取这个非负数对应到byte数组中的索引，也就是对应数组中哪个位置的元素
            int innerIndex = (int) (bitIndex % 8);    //判断这个num对应数组这个位置元素的哪一位（bit）

            System.out.println("byte[" + index + "] 中的索引：" + innerIndex + "  1 << innerIndex：" + 2 * innerIndex);

            //整型数中的1对应byte数中索引为0的那一位，也就是2^innerIndex（1 << innerIndex）
            dataBytes[index] = (byte) (dataBytes[index] | (1 << innerIndex));
            return dataBytes;
        }

        /**
         * 输出数组中的数据
         * @param bytes byte数组
         */
        private void output(byte[] bytes) {
            int count = 0;
            for (int i = 0; i < bytes.length; i++) {
                for (int j = 0; j < 8; j++) {
                    if (!(((bytes[i]) & (1 << j)) == 0)) {
                        count++;
                        int number = (int) ((((long) i * 8 + j) - (1L << 31)));
                        System.out.println("取出的第  " + count + "\t个数: " +  number);
                    }
                }
            }
        }
    }

}
