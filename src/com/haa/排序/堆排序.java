package com.haa.排序;

public class 堆排序 {
    void headSort(int[] arr){
        int n = arr.length;
        //首先构建大顶堆，从构建的二叉树的叶子节点的上一层节点开始下沉操作，一直到索引为0的位置，也就是根节点
        //此时所有需要下沉的节点都下沉了，就变成了大顶堆
        for(int i = (n-2)/2; i>= 0; i-- ){
            downAdjust(arr,i,n-1);
        }
        //进行堆排序
        for(int i = n-1; i >= 1; i--){
            //把堆顶元素(最大元素)与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性（此时只需要让堆顶节点下沉，就可以构建大顶堆）
            downAdjust(arr,0,i-1);
        }
    }
    //下沉操作，（由于从下往上下沉，一趟下沉操作完成后，以下沉节点为根节点的堆一定变成大顶堆）
    private void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while(child <= n){
            if(child + 1 <= n && arr[child] < arr[child+1])
                child++;
            //如果孩子节点小于或等于父节点，则下沉结束
            if(arr[child] < temp ) break;
            //父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
}
