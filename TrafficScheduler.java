import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("Traffic Flow Order (BFS): ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbour : adjacencyList[node]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }
}

public class TrafficScheduler {
    public static void main(String[] args) {
        Graph trafficGraph = new Graph(6);

        trafficGraph.addEdge(0, 1);
        trafficGraph.addEdge(0, 2);
        trafficGraph.addEdge(1, 3);
        trafficGraph.addEdge(2, 4);
        trafficGraph.addEdge(3, 5);
        trafficGraph.addEdge(4, 5);

        System.out.println("Graph-Based Traffic Scheduling System");
        trafficGraph.bfs(0);
    }
}
