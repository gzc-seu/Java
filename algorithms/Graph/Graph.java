package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    //定义给数组boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;

    //构造器,初始化矩阵和vertexList
    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
    }
    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for(int[] link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //得到第一个邻接结点的下标 w
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertexList.size();j++){
            if(edges[index][j]>0) return j;
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited, int i){
        System.out.print(getValueByIndex(i)+ "->");
        isVisited[i]=true;
        int w=getFirstNeighbor(i);
        while(w!=-1){
            if(isVisited[w]!=true) dfs(isVisited,w);
            w=getNextNeighbor(i,w);
        }
    }
    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs(){
        isVisited=new boolean[vertexList.size()];
        for(int i=0;i<vertexList.size();i++)
        {
            while(isVisited[i]!=true){
                dfs(isVisited,i);
            }
        }
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i){
        int u,w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+ "->");
        isVisited[i]=true;
        queue.addLast(i);
        while(!queue.isEmpty()){
            u= (int) queue.removeFirst();
            w=getFirstNeighbor(u);
            while(w!=-1){
                if(isVisited[w]!=true) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w=getNextNeighbor(i,w);
            }
        }
    }
    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;  //结点的个数
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph=new Graph(n);
        for(String s:Vertexs){
            graph.insertVertex(s);
        }
        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        graph.showGraph();

        System.out.println("深度遍历");
        graph.dfs();
        System.out.println("广度优先");
        graph.bfs();
    }
}
