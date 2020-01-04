package LeetCode.A501v2000.A785IsGraphBipartite;

class Solution {
    int V = 100;
    boolean[]color = new boolean[V];
    boolean[]marked = new boolean[V];
    boolean isBipartite = true;
    public boolean isBipartite(int[][] graph) {
        for(int i = 0; i < graph.length; i++){
            if(!isBipartite){//已知非二分图，提前结束
                break;
            }
            if(!marked[i]){
                dfs(graph,i);
            }
        }
        return isBipartite;
    }
    private void dfs(int[][]graph,int i){
        if(!isBipartite){//已知非二分图，提前结束
            return;
        }
        marked[i] = true;
        for(int neighbor : graph[i]){
            if(!marked[neighbor]){
                color[neighbor] = !color[i];
                dfs(graph,neighbor);
            }else if(color[neighbor] == color[i]){
                isBipartite = false;
            }
        }
    }
}