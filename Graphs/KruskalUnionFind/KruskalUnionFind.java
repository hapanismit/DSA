package KruskalUnionFind;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Edge{
	int source;
	int destiantion;
	int weight;

	Edge(int source, int destiantion, int weight){
		this.source = source;
		this.destiantion = destiantion;
		this.weight = weight;
	}
}

class Graph{
	int vertices;
	ArrayList<Edge> Edges = new ArrayList<>();

	Graph(int vertices){
		this.vertices = vertices;
	}

	public void addEdge(int source, int destiantion, int weight){
		Edges.add(new Edge(source, destiantion, weight));
	}

	public void kruskal(){
		PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
		
		for(int i = 0; i < Edges.size(); i++){
			pq.add(Edges.get(i));
		}

		int[] parent = new int[vertices];

		for(int i = 0; i < vertices; i++){
			parent[i] = -1;
		}

		ArrayList<Edge> mst = new ArrayList<>();
		int index = 0;

		while(index < vertices - 1){
			Edge edge = pq.remove();
			int sp = find(parent, edge.source);
			int dp = find(parent, edge.destiantion);

			if(sp != dp){
				union(parent, sp, dp);
				index++;
				mst.add(edge);
			}
		}
		printGraph(mst);
	}
	public void printGraph(ArrayList<Edge> edgeList){
		int cost = 0;
		for (int i = 0; i <edgeList.size() ; i++) {
			Edge edge = edgeList.get(i);
			cost += edge.weight;
			System.out.println("Edge-" + i + " source: " + edge.source +
					" destination: " + edge.destiantion +
					" weight: " + edge.weight);
		}
		System.out.println("MST cost = " + cost);
	}

	public int find(int[] parent, int x){

		if(parent[x] != -1){
			return find(parent, parent[x]);
		}
		return x;

	}

	public void union(int[] parent, int x, int y){
		int xp = find(parent, x);
		int yp = find(parent, y);

		parent[xp] = yp;
	}
}

public class KruskalUnionFind{
	public static void main(String[] args) {
		Graph g = new Graph(6);

		g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);
        g.kruskal();

	}
}