import java.util.Arrays;

public class ShortestPathDP {

    // Function to find the shortest path in a graph using dynamic programming
    public static int shortestPath(int[][] graph, int source, int destination) {
        int numVertices = graph.length;
        int[] dp = new int[numVertices];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[source] = 0;

        for (int vertex = 0; vertex < numVertices; vertex++) {
            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                if (graph[vertex][neighbor] != 0 && dp[vertex] != Integer.MAX_VALUE) {
                    dp[neighbor] = Math.min(dp[neighbor], dp[vertex] + graph[vertex][neighbor]);
                }
            }
        }

        return dp[destination];
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source = 0;
        int destination = 4;

        int shortestDistance = shortestPath(graph, source, destination);

        System.out.println("Shortest distance from " + source + " to " + destination + ": " + shortestDistance);
    }
}
