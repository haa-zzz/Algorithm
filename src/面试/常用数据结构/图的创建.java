package 面试.常用数据结构;

public class 图的创建 {

}

/**
 * 邻接矩阵无向图
 */
class MatrixNDG {
    int size;//图顶点个数
    char[] vertexs;//图顶点名称
    int[][] matrix;//图关系矩阵
    public MatrixNDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];//设定图关系矩阵大小
        this.vertexs=vertexs;

        for(char[] c:edges){//设置矩阵值
            int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
            int p2 = getPosition(c[1]);

            matrix[p1][p2] = 1;//无向图，在两个对称位置存储
            matrix[p2][p1] = 1;
        }
    }
    //图的遍历输出
    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }
}

/**
 * 邻接矩阵有向图
 */
class MatrixDG {
    int size;
    char[] vertexs;
    int[][] matrix;
    public MatrixDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];
        this.vertexs=vertexs;
        //和邻接矩阵无向图差别仅仅在这里
        for(char[] c:edges){
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);
            matrix[p1][p2] = 1;
        }
    }
    public void print(){
        for(int[] i:matrix){
            for(int j:i)    System.out.print(j+" ");
            System.out.println();
        }
    }
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }
    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{{'A', 'C'}, {'A', 'D'}, {'A', 'F'}, {'B', 'C'}, {'C', 'D'},
                {'E', 'G'}, {'D', 'G'}, {'I','J'}, {'J','G'},};
        MatrixDG pG;
        pG = new MatrixDG(vexs, edges);
        pG.print();
    }
}

/**
 * 邻接表无向图
 */
class ListNDG {
    Vertex[] vertexLists;//邻接表数组
    int size;
    class Vertex{//邻接表节点类，单链表数据结构
        char ch;
        Vertex next;
        Vertex(char ch){//初始化方法
            this.ch=ch;
        }
        void add(char ch){//加到链表尾
            Vertex node=this;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new Vertex(ch);
        }
    }
    public ListNDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        this.vertexLists=new Vertex[size];//确定邻接表大小
        //设置邻接表头节点
        for(int i=0;i<size;i++){
            this.vertexLists[i]=new Vertex(vertexs[i]);
        }
        //存储边信息
        for(char[] c:edges){
            int p1=getPosition(c[0]);
            vertexLists[p1].add(c[1]);
            int p2=getPosition(c[1]);
            vertexLists[p2].add(c[0]);
        }

    }
    //跟据顶点名称获取链表下标
    private int getPosition(char ch) {
        for(int i=0; i<size; i++)
            if(vertexLists[i].ch==ch)
                return i;
        return -1;
    }
    //遍历输出邻接表
    public void print(){
        for(int i=0;i<size;i++){
            Vertex temp=vertexLists[i];
            while(temp!=null){
                System.out.print(temp.ch+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C'}, {'A', 'D'}, {'A', 'F'}, {'B', 'C'}, {'C', 'D'}, {'E', 'G'}, {'D', 'G'}, {'I','J'}, {'J','G'},};
        ListNDG pG= new ListNDG(vexs, edges);
        pG.print();
    }
}

/**
 * 邻接表有向图
 */
class ListDG {
    Vertex[] vertexLists;
    int size;
    class Vertex{
        char ch;
        Vertex next;

        Vertex(char ch){
            this.ch=ch;
        }
        void add(char ch){
            Vertex node=this;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new Vertex(ch);
        }
    }
    public ListDG(char[] vertexs,char[][] edges){
        size=vertexs.length;
        this.vertexLists=new Vertex[size];
        for(int i=0;i<size;i++){
            this.vertexLists[i]=new Vertex(vertexs[i]);
        }
        for(char[] c:edges){
            int p=getPosition(c[0]);
            vertexLists[p].add(c[1]);
        }
    }
    private int getPosition(char ch) {
        for(int i=0; i<size; i++)
            if(vertexLists[i].ch==ch)
                return i;
        return -1;
    }
    public void print(){
        for(int i=0;i<size;i++){
            Vertex temp=vertexLists[i];
            while(temp!=null){
                System.out.print(temp.ch+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}