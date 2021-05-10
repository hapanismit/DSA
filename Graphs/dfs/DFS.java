package dfs;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

class Graph{
    List<List<Integer>> graph;
    boolean visited[];

    Graph(int nodes){
        graph = new ArrayList<>();
        visited = new boolean[nodes];

        for(int i = 0; i < nodes; i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int a, int b){
        graph.get(a).add(b);
    }

    public void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        

        visited[start] = true;

        while(!stack.isEmpty()){
            Integer node = stack.pop();
            System.out.print(node+" ");
            
            List<Integer> neighbours = graph.get(node);
            for(Integer neighbour : neighbours){
                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        System.out.println();
    }

}

public class DFS {
    public static void main(String args[]){
        int node = 4;

        Graph g = new Graph(node);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(2);

    }
}

