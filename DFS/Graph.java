package DFS;
import java.util.*;

public class Graph {
    private int numOfVertices;
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int num) {
        numOfVertices = num;
        adj = new LinkedList[num];
        for (int i=0; i<num; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // adding edge
    void addEdge(int src, int dest) {
        adj[src].add(dest);
    }

    // recursive function
    void dfsRec(int vertex,boolean visited[]) {
        visited[vertex] = true;
        //do something here...
        System.out.print(vertex + " ");

        // Iterator<Integer> i = adj[vertex].listIterator();
        // while (i.hasNext()) {
        //     int n = i.next();
        //     if (!visited[n])
        //         dfsRec(n, visited);
        // }
        for(int i : adj[vertex]) {
            if(!visited[i])
                dfsRec(i, visited);
        }
    }

    void DFS() {
        boolean visited[] = new boolean[numOfVertices];

        for (int i=0; i<numOfVertices; ++i)
            if (visited[i] == false)
                dfsRec(i, visited);
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);

        System.out.println("Result:");

        g.DFS();
    }
}