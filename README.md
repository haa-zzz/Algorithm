@[TOC](目录)

# 0.概念

## 0.1 内部排序和外部排序

内部排序是数据记录在内存中进行排序，而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。如下的排序都是内部排序。

## 0.2 稳定排序和非稳定排序

假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的。

## 0.3 图解

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210402182103595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhYXp6eg==,size_16,color_FFFFFF,t_70#pic_center)


# 1. 直接插入排序

&nbsp;

## 1.1 思想

是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中**从后向前**扫描，找到相应位置并插入。插入排序在实现上，通常采用 in-place 排序，因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
&nbsp;

## 1.2 步骤和演示

&nbsp;
***步骤：***

  1. 从第一个元素开始，该元素可以认为已经被排序；
  2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
  3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
  4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
  5. 将新元素插入到该位置后；
  6. 重复步骤2~5。
     &nbsp;

***演示：***
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210419224236562.gif#pic_center)


&nbsp;

## 1.3 代码实现

```java
public static void insertionSort(int[] array) {
       if(array.length < 2){
           return;
       }
       int cur;     //存储当前要排序的元素
       for(int i = 0; i < array.length -1; i++){
           cur = array[i+1];    //第一个数默认已经排好，直接从第二个数开始
           int pre = i;
           while(pre >= 0 && cur < array[pre] ){
               array[pre + 1] = array[pre];         //把大于当前数的元素后移
               pre--;
           }
           array[pre + 1] = cur;         //把这个数插入
       }
    }
```

&nbsp;

## 1.4 复杂度和稳定性分析

 - 时间复杂度： 最好O(N)  ， 平均O(N^2)
 - 空间复杂度： O(1)
 - 稳定性：直接插入排序的过程中，不需要改变相等数值元素的位置，所以它是稳定的算法。
   &nbsp; 

## 1.5 折半插入排序优化

折半插入排序（Binary Insertion Sort）是对插入排序算法的一种改进，所谓排序算法过程，就是不断的依次将元素插入前面已排好序的序列中，在寻找插入点时采用了折半查找。

***二分过程简析：***
&nbsp;
取有序数据分区的第一个元素位置为low，最后一个元素的位置为high。用中点mid将其平分为两部分，然后将待排序数据同中间位置为mid的数据进行比较，若待排序数据较大，则（low ~ m-1）分区的数据都比待排序数据小，反之，若待排序数据较小，则（m+1~high）分区的数据都比 待排序数据大，此时将low或high重新定义为新的合适分区的边界，对新的小分区重复上面操作。直到low和high 的前后顺序改变，此时low == high+1所处位置为待排序数据的合适位置。
&nbsp;
***复杂度和稳定性：***
&nbsp;
折半插入排序是直接插入排序的改进，它的时间复杂度，空间复杂度，稳定性与直接插入排序相同（只是比较此数不同）

&nbsp;

## 1.6 优化代码

```java
public static void insertionSortPro(int[] array){
        if(array.length < 2){
            return;
        }
        int cur;            //存储当前要排序的元素
        int low,high;       //二分查找


        for(int i = 0; i < array.length-1; i++){

            cur = array[i+1];
            low = 0;
            high = i;
            while(low <= high){

                int mid = low + (high-low)/2;

                if( array[mid] > cur ){
                    high = mid-1;
                }else{              //说明中间的数 <= cur
                    low = mid + 1;
                }
            }                               //二分查找完后，low索引对应插入位置，high索引对应插入位置-1
            for(int j = i; j >= low; j--){
                array[j+1] = array[j];
            }
            array[low] = cur;

        }
    }
```

&nbsp;

# 2. 希尔排序

&nbsp;

## 2.1 思想

将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，是一种优化的直接插入排序
&nbsp;

## 2.2	步骤及演示

先让数组中任意间隔为 gap 的元素有序，刚开始 gap 的大小可以是 gap = n / 2,接着让 gap = n / 4，让 gap 一直缩小，当 gap = 0 时，此时的数组就是有序的了。
&nbsp;
***图片演示：***
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210420180334378.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhYXp6eg==,size_16,color_FFFFFF,t_70)
&nbsp;

## 2.3 代码实现

```java
public static void ShellSort(int[] array) {
        
        int len = array.length;
        
        if(len < 2){
            return;
        }
        int cur, gap = len / 2;
        
        while (gap > 0) {	
        
        	//分成了gap组，前面0~gap-1分别是各组的第一个元素，可以认为是默认排好的，下标从gap开始做插入排序
            for (int i = gap; i < len; i++) {       
                cur = array[i];
                int pre = i - gap;
                while (pre >= 0 && array[pre] > cur) {
                    array[pre + gap] = array[pre];
                    pre -= gap;
                }
                array[pre + gap] = cur;
            }
            gap /= 2;
        }
    }
```

&nbsp;

## 2.4 复杂度和稳定性分析

 - 时间复杂度：O(nlogn)~ O(n2)
 - 空间复杂度： O(1)
 - 稳定性：不稳定
   &nbsp;

# 3. 简单选择排序

## 3.1 思想

&nbsp;
首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
&nbsp;

## 3.2 步骤和演示

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210421155744389.gif#pic_center)
&nbsp;

## 3.3 代码实现

```java
public static void SelectionSort(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        for(int i = 0; i < n-1; i++){
            int minIndex = i;           //记录最小的下表位置
            for(int j = i+1; j < n; j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(array[i] != array[minIndex]){        //如果他俩相等，异或运算后两者都变为0
                array[i]  = array[i] ^ array[minIndex];     //交换两个数
                array[minIndex] = array[i] ^ array[minIndex];
                array[i] = array[i] ^ array[minIndex];
            }
        }
    }
```

## 3.4 复杂度和稳定性分析

 - 时间复杂度： O（N^2）
 - 空间复杂度： O(1)
 - 稳定性：不稳定排序
   &nbsp; 

## 3.5 简单选择排序的优化

 - 思路：在每一次查找最小值的时候，也可以找到一个最大值，然后将两者分别放在它们应该出现的位置，这样遍历的次数就比较少了
 - 实现


```kotlin
public static void SelectionSortPro(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        int left = 0;
        int right = n-1;

        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            for(int i = left; i <= right; i++){
                if(array[minIndex] >  array[i]){
                    minIndex = i;
                }
                if(array[maxIndex] < array[i]){
                    maxIndex = i;
                }
            }

            if(minIndex != left){
                array[left]  = array[left] ^ array[minIndex];     //交换两个数
                array[minIndex] = array[left] ^ array[minIndex];
                array[left] = array[left] ^ array[minIndex];
            }
			//如果left索引位置为最大值，由于left和minIndex交换了，所以 maxIndex = minIndex;
            if(left == maxIndex)            
                maxIndex = minIndex;       
             //还有一种情况，minIndex索引位置为最大值，说明最小值和最大值的索引相同，
             //即只剩最后一个元素了，此时可以不做处理    
                                            
            if(maxIndex != right){
                array[right]  = array[right] ^ array[maxIndex];     //交换两个数
                array[maxIndex] = array[right] ^ array[maxIndex];
                array[right] = array[right] ^ array[maxIndex];
            }
            left++;
            right--;

        }

    }
```

 - 复杂度分析：还是O(N^2)
 - &nbsp; 

# 4. 堆排序

&nbsp; 

## 4.1 堆的介绍

堆是一颗顺序存储的完全二叉树
每个结点的关键字都不大于其孩子结点的关键字，这样的堆称为小根堆
每个结点的关键字都不小于其孩子结点的关键字，这样的堆称为大根堆
对于n个元素的序列{R0, R1,R2,.......,Rn}当且仅当下列关系之一的时候，称之为堆

     （1） Ri <= R2i + 1 且 Ri <= R2i + 2 （小根堆）
    
     （2） Ri >= R2i + 1 且 Ri >= R2i + 2 （大根堆）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210421171242308.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2hhYXp6eg==,size_16,color_FFFFFF,t_70)
对于堆中的一个节点如果在数组中表示为R[i]：

 - 它的左孩子是R[2*i+1]
 - 它的右孩子是R[2*i+2]
 - 它的父结点是R[(i-1)/2]

## 4.2 思想

 堆排序（Heapsort） 是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

## 4.3 步骤和演示

***步骤：***

  1. 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
  2. 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
  3. 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。


***演示：***
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210421171835521.png#pic_center)

## 4.4 代码实现

```java
public static void headSort(int[] array) {
        int n = array.length;
        //构建大顶堆
        //从构建的二叉树的叶子节点的上一层节点开始下沉操作，一直到索引为0的位置，也就是根节点，
        //此时所有需要下沉的节点都下沉了，就变成了大顶堆
        for (int i = (n - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性（此时只需要让堆顶节点下沉，就可以构建大顶堆）
            downAdjust(array, 0, i - 1);
        }

    }
    //下沉（由于从下往上下沉，一趟下沉操作完成后，以下沉节点为根节点的堆一定变成大顶堆）
    public static void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp ) break;
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }
```

## 4.5 复杂度和稳定性分析

 - 时间复杂度：O(nlogn)）
 - 空间复杂度： O(1)
 - 稳定性：不稳定排序。因为在堆的调整过程中，关键字进行比较和交换所走的是该结点到叶子结点的一条路径，因此对于相同的关键字就可能出现排在后面的关键字被交换到前面来的情况
   &nbsp; 

## 4.6 参考博客

[堆排序详解--大顶堆](https://blog.csdn.net/breakpoints_/article/details/87920522)

# 5. 冒泡排序

&nbsp; 

## 5.1 思想

重复走访要排序的数列，一次比较两个元素，若较小元素在后则交换，能看到越小的元素会经由交换慢慢浮到数列的顶端

##  5.2 步骤和演示

***步骤***

  1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
  2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样一趟结束后最后的元素为最大的元素。
  3. 针对所有的元素重复以上的步骤，除了排好序的；

  &nbsp; 
 ***演示***


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210422161511942.gif#pic_center)

##  5.3 代码实现

```java
public static void bubbleSort(int[] array) {
        int n = array.length;
        if(n < 2){
            return;
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(array[j] > array[j+1]){
                    array[j] = array[j] ^ array[j+1];
                    array[j+1] = array[j] ^ array[j+1];
                    array[j] = array[j] ^ array[j+1];
                }
            }
        }
    }
```

## 5.4 复杂度和稳定性分析

 - 时间复杂度：O(n^2）
 - 空间复杂度： O(1)
 - 稳定性：稳定排序。
   &nbsp; 

## 5.5 冒泡排序的优化

 - 思路：假如从开始的第一对到结尾的最后一对，相邻的元素之间都没有发生交换的操作，这意味着右边的元素总是大于等于左边的元素，此时的数组已经是有序的了，我们无需再对剩余的元素重复比较下去了。
 - 实现


```java
public static void bubbleSortPro(int[] array) {        int n = array.length;        if(n < 2){            return;        }        for(int i = 0; i < n-1; i++){            boolean boo = true;         //增加标志位来判断是否有交换数            for(int j = 0; j < n-i-1; j++){                if(array[j] > array[j+1]){                    boo = false;                    array[j] = array[j] ^ array[j+1];                    array[j+1] = array[j] ^ array[j+1];                    array[j] = array[j] ^ array[j+1];                }            }            if(boo){                break;            }        }    }
```

 &nbsp; 

# 6. 快速排序

## 6.1 思想

取一个记录作为枢轴，经过一趟排序将整段序列分为两个部分，使得数轴左侧都小于枢轴、右侧都大于枢轴；再对这两部分继续进行排序使整个序列达到有序

##  6.2 步骤和演示

***步骤***

  1. 从数列中挑出一个元素，称为 “基准”（pivot ）
  2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
  3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

  &nbsp; 
 ***演示***
 &nbsp; ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210422190222929.gif#pic_center)

##  6.3 代码实现

&nbsp; 

```java
	/**     * @param array 待排序的数组     *     * @param left  要排序的第一个元素的索引(包括)     *     * @param right 最后一个要排序的元素的索引(不包括)     *     */    public static void quickSort(int[] array,int left,int right) {        if(left < right-1){            //获取中轴元素所处的索引            int pivot = partition(array,left,right-1);            //进行分割            quickSort(array,left,pivot);            quickSort(array,pivot+1,right);        }    }    private static int partition(int[] array, int low, int high) {        //选取中轴元素        int pivotKey = array[low];     //首先选最左边的元素记为中轴元素        while(low < high){            while(low < high && array[high] >= pivotKey)                high--;            swap(array,low,high);            while(low < high && array[low] <= pivotKey)                low++;            swap(array,low,high);        }        return low;    }    private static void swap(int[] array, int a, int b) {        if(a != b){            array[a] = array[a] ^ array[b];            array[b] = array[a] ^ array[b];            array[a] = array[a] ^ array[b];        }    }
```

 &nbsp; 

##  6.4 复杂度和稳定性分析

  1. 时间复杂度：O( nlogn ）
  2. 空间复杂度： O(logn)
  3. 稳定性：不稳定排序。因为关键字的比较和交换是跳跃进行的。
     &nbsp; 

##  6.5 快速排序的优化

***思想***

  1. 优化选取枢轴

 	三数取中法——对待排序序列中low、mid、high三个位置上数据进行排序，取他们中间的那个数据作为枢轴，并用0下标元素存储枢轴。

```java
        int mid = low + (high-low)/2;        if(array[low] > array[high])            swap(array,low,high);        if(array[mid] > array[high])            swap(array,mid,high);        if(array[mid] > array[low])            swap(array,low,mid);        int pivotKey = array[low];    
```

  2. 优化不必要的交换

 	刚才的交换可以用替换代替。


```java
		int pivotKey = array[low];     //首先选最左边的元素记为中轴元素        int backus = pivotKey;           //将枢轴关键字备份到backus        while (low < high) {            while (low < high && array[high] >= pivotKey)                high--;            array[low] = array[high];       //采用替换而不是交换的方式进行操作            while (low < high && array[low] <= pivotKey)                low++;            array[high] = array[low];       //采用替换而不是交换的方式进行操作        }        array[low] = backus;              //将枢轴数值替换回array[low]        return low;                         //返回枢轴所在位置
```

  3. 优化小数组时的排序方案

 	对于很小和部分有序的数组，快排不如插排好。当待排序序列的长度分割到一定大小后，继续分割的效率比插入排序要差，此时可以使用插排而不是快排

```java
	public static final int MAX_LENGTH_INSERT_SORT  = 7;    //数组长度阈值    public static void quickSortPro(int[] array, int left, int right) {        if ( (right - left) > MAX_LENGTH_INSERT_SORT ) {    //大于阈值采用快排             //获取中轴元素所处的索引            int pivot = partition(array, left, right - 1);            //进行分割            quickSort(array, left, pivot);            quickSort(array, pivot + 1, right);            }        }        else{                                               //小于阈值采用插入排序            insertionSort(array);        }    }
```

  5. 优化递归过程

 	采用尾递归来优化递归过程


```java
public static void quickSortPro(int[] array, int left, int right) {        if ( (right - left) > MAX_LENGTH_INSERT_SORT ) {    //大于阈值采用快排            while(left < right){                //获取中轴元素所处的索引                int pivot = partitionPro(array, left, right - 1);                //进行分割                quickSort(array, left, pivot);                left = pivot+1;                //递归一次后，low就失去左右，可以让 low = pivot+1，加上while循环相当于quickSort(array, pivot + 1, right);            }        }        else{                                               //小于阈值采用插入排序            insertionSort(array);        }    }
```


 ***完整优化代码实现***


```java
	public static final int MAX_LENGTH_INSERT_SORT  = 7;    //数组长度阈值    public static void quickSortPro(int[] array, int left, int right) {        if ( (right - left) > MAX_LENGTH_INSERT_SORT ) {    //大于阈值采用快排            while(left < right){                //获取中轴元素所处的索引                int pivot = partitionPro(array, left, right - 1);                //进行分割                quickSort(array, left, pivot);                left = pivot+1;                //递归一次后，low就失去左右，可以让 low = pivot+1，加上while循环相当于quickSort(array, pivot + 1, right);            }        }        else{                                               //小于阈值采用插入排序            insertionSort(array);        }    }    private static int partitionPro(int[] array, int low, int high) {               int mid = low + (high-low)/2;        if(array[low] > array[high])            swap(array,low,high);        if(array[mid] > array[high])            swap(array,mid,high);        if(array[mid] > array[low])            swap(array,low,mid);                int pivotKey = array[low];     //首先选最左边的元素记为中轴元素        int backus = pivotKey;           //将枢轴关键字备份到backus        while (low < high) {            while (low < high && array[high] >= pivotKey)                high--;            array[low] = array[high];       //采用替换而不是交换的方式进行操作            while (low < high && array[low] <= pivotKey)                low++;            array[high] = array[low];       //采用替换而不是交换的方式进行操作        }        array[low] = backus;              //将枢轴数值替换回array[low]        return low;                         //返回枢轴所在位置    }
```

 

# 7. 归并排序

## 7.1 思想

将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，之后在把这两个数组合并成一个有序的数组。由于两个小的数组都是有序的，所以在合并的时候是很快的。

## 7.2 步骤和演示

***步骤***

 1.把长度为n的输入序列分成两个长度为n/2的子序列；

  2. 对这两个子序列分别采用归并排序；
  3. 将两个排序好的子序列合并成一个最终的排序序列。

  &nbsp; 
 ***演示***
 &nbsp; 
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210423154530888.png#pic_center)

##  7.3 代码实现

&nbsp; 

```java
 /**     *归并排序     *      * @param array     待排序的数组     * @param left      要排序的第一个元素的索引(包括)     * @param right     最后一个要排序的元素的索引(不包括)     */    public static void MergeSort(int[] array,int left,int right) {        //如果 left==right-1,表示数组只有一个元素，则不用递归排序        if( left < (right-1) ){            //分割数组            int mid = left + (right-left+1)/2;            //对左半部分进行排序            MergeSort(array,left,mid);            //对右半部分进行排序            MergeSort(array,mid,right);            //进行合并            merge(array,left,mid,right);        }    }    private static void merge(int[] array, int left, int mid, int right) {        //先用一个临时数组把他们合并汇总起来        int[] a = new int[right - left];        int i = left;        int j = mid ;        int k = 0;        while (i < mid && j < right) {            if (array[i] < array[j]) {                a[k++] = array[i++];            } else {                a[k++] = array[j++];            }        }        while(i < mid) a[k++] = array[i++];        while(j < right) a[k++] = array[j++];        // 把临时数组复制到原数组        for (i = 0; i < k; i++) {            array[left++] = a[i];        }    }
```

## 7.4 复杂度和稳定性分析

 - 时间复杂度：O(nlog(n)）
 - 空间复杂度： O(n)
 - 稳定性：稳定排序。
   &nbsp; 

# 8. 基数排序

##  8.1 思想

按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。
 &nbsp; 

##  8.2  步骤和演示

***步骤***

  1. 取得数组中的最大数，并取得位数；
  2. array为原始数组，从最低位开始取每个位组成radix数组；
  3. 对radix进行桶排序；


 ***演示***
 &nbsp; 
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210423162939893.gif#pic_center)

##  8.3 代码实现

```java
public static void RadioSort(int[] array) {        int n = array.length;        if(n < 2){            return;        }        //寻找最大值        int max = array[0];        for(int i = 1; i < n; i++){            if(max < array[i]){                max = array[i];            }        }        // 计算最大值是几位数        int num = 1;        while (max / 10 > 0) {            num++;            max = max / 10;        }        // 创建10个桶        ArrayList< LinkedList<Integer> > bucketList = new ArrayList<>(10);        //初始化桶        for (int i = 0; i < 10; i++) {            bucketList.add(new LinkedList<Integer>());        }        // 进行每一趟的排序，从个位数开始排        for(int i = 1; i <= num; i++){            for(int j = 0; j < n; j++){                // 获取每个数最后第 i 位                int radio = (array[j] / (int)Math.pow(10,i-1)) % 10;                //放进对应的桶里                bucketList.get(radio).add(array[j]);            }            //合并放回原数组            int k = 0;            for(int j = 0; j < 10; j++){                for(Integer t : bucketList.get(j)){                    array[k++] = t;                }                bucketList.get(j).clear();            }        }    }
```

##  8.4 复杂度和稳定性分析

 - 时间复杂度：O(k * n）
 - 空间复杂度： O(n+k)
 - 稳定性：稳定排序。

# 总结

| 名称 | 时间复杂度| 空间复杂度 |稳定性  |  适用|
|--|--|--|--|--|--|
| 直接插入排序 | 最好O(n)，平均O(n2) | O(1) |稳定  | 数据规模较小且待排序列基本有序  |
| 希尔排序 | O(nlogn) | O(1) | 不稳定 |  数据规模较大 |
|简单选择排序  | O(n2) | O(1) | 稳定 |  数据规模较小且对稳定性有要求 |
| 堆排序 |O(nlogn)  | O(1) | 不稳定 |  数据规模较大，相比快排好处是不会出现最坏情况、需要的辅助空间少 |
| 冒泡排序 |O(n2)  | O(1) |稳定  |数据规模较小   |
| 快速排序 |最坏 O(n2)，平均O(nlogn)  | O(logn)~O(n) |不稳定  |数据规模较大且待排序列无序   |
|归并排序  | O(nlogn) | O(n) | 稳定 |  数据规模较大且对稳定性有要求 |
| 基数排序   | O(n*k) | O(n+k) | 稳定 |  正整型数据 |
