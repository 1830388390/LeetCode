package A501v2000.A1192CriticalConnectionsinaNetwork;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    List<Integer>[] undirectedGraph;
    int[] num;
    int[] low;
    List<List<Integer>> res;
    int time;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.undirectedGraph = new ArrayList[n];
        for (int i = 0;i<n;i++){
            undirectedGraph[i] = new ArrayList<>();
        }
        for (List<Integer> tmp : connections){
            undirectedGraph[tmp.get(0)].add(tmp.get(1));
            undirectedGraph[tmp.get(1)].add(tmp.get(0));
        }
        this.num = new int[n];
        this.low = new int[n];
        Arrays.fill(num,-1);
        time = 0;
        this.res = new ArrayList<>();
        run(n);
        return res;
    }
    private void DFS(int n,int parent){
        time++;
        low[n] = time;
        num[n] = time;
        for (int i : undirectedGraph[n]){
            if (i == parent){
                continue;
            }
            if (num[i] == -1){
                DFS(i,n);
                low[n] = Integer.min(low[n],low[i]);
                if (low[i]>num[n]){
                    res.add(Arrays.asList(i,n));
                }
            }else {
                low[n] = Integer.min(low[n],num[i]);
            }
        }
    }
    private void run(int n){
        for (int i = 0;i<n;i++){
            if (num[i] == -1){
                DFS(i,i);
            }
        }
    }
}

class Tarjan {
    private int numOfNode;
    private List<ArrayList<Integer>> graph;// 图
    private List<ArrayList<Integer>> result;// 保存极大强连通图

    private boolean[] inStack;// 节点是否在栈内
    private Stack<Integer> stack;
    private int[] dfn;
    private int[] low;
    private int time;

    public Tarjan(List<ArrayList<Integer>> graph, int numOfNode) {
        this.graph = graph;
        this.numOfNode = numOfNode;
        this.inStack = new boolean[numOfNode];
        this.stack = new Stack<Integer>();
        dfn = new int[numOfNode];
        low = new int[numOfNode];

        Arrays.fill(dfn, -1);// 将dfn所有元素都置为1，其中dfn[i]=-1代表这个点没有被访问过
        result = new ArrayList<ArrayList<Integer>>();
    }

    public void tarjan(int current) {
        dfn[current] = low[current] = time++;
        inStack[current] = true;
        stack.push(current);

        for (int i = 0; i < graph.get(current).size(); i++) {
            int next = graph.get(current).get(i);
            if (dfn[next] == -1) {
                tarjan(next);
                low[current] = Math.min(low[current], low[next]);
            } else if (inStack[next]) {
                low[current] = Math.min(low[current], dfn[next]);
            }
        }
        if (low[current] == dfn[current]) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int j = -1;
            while (current != j) {
                j = stack.pop();
                inStack[j] = false;
                temp.add(j);
            }
            result.add(temp);
        }
    }

    public List<ArrayList<Integer>> run() {
        for (int i = 0; i < numOfNode; i++) {
            if (dfn[i] == -1) {
                tarjan(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // 创建图
        int numOfNode = 6;
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numOfNode; i++) {
            graph.add(new ArrayList<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        graph.get(2).add(4);
        graph.get(3).add(0);
        graph.get(3).add(5);
        graph.get(4).add(5);

        Tarjan t = new Tarjan(graph, numOfNode);
        List<ArrayList<Integer>> result = t.run();
        // 打印结果

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}