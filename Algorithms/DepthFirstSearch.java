package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS(2);
    }
}


class Graph {
    private int numVertices;
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    public Graph(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator ite = adjLists[vertex].listIterator();
        while (ite.hasNext())
        {
            int adj = (int) ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }
}
