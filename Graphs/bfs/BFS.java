package bfs;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

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

    
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            System.out.print(node + " ");
            
            List<Integer> neighbours = graph.get(node);
            for(Integer neighbour : neighbours){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour] = true;
                }    
            }
        }
        System.out.println();
    }

}

public class BFS {
    public static void main(String args[]){
        int node = 4;

        Graph g = new Graph(node);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);
    }
}

