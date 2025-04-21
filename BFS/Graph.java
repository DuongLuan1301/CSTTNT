package BFS;
import java.util.*;

public class Graph {
    private int numOfVertices;
    private LinkedList<Integer> adj[];

    //constructor
    Graph(int nums) {
        numOfVertices = nums;
        adj = new LinkedList[nums];
        for(int i=0; i<nums; i++)
            adj[i] = new LinkedList<>();
    }

    //adding adge
    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void BFS(int startNode) {
        boolean visited[] = new boolean[numOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            //do something here...
            System.out.print(u + " ");
            for(int v : adj[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        Graph G = new Graph(5);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(0, 3);
        G.addEdge(2, 4);

        System.out.println("Result: ");
        G.BFS(0);
    }
}
