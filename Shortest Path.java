package dp;

import java.util.Arrays;

public class ShortestPath {

    // Function to find the shortest path in a graph using dynamic programming
    public static int shortestPath(int[][] graph, int source, int destination) {
        int v = graph.length;
        int[] dp = new int[v];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[source] = 0;

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (graph[i][j] != 0 && dp[i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[i] + graph[i][j]);
                }
            }
        }

        return dp[destination];
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, 1, 0},
                {0, 0, 0, 5},
                {0, 0, 0, 2},
                {0, 0, 0, 0}
        };

        int source = 0;
        int destination = 3;

        int shortestPath = ShortestPath.shortestPath(graph, source, destination);
        System.out.println("Shortest path from " + source + " to " + destination + ": " + shortestPath);
    }
}
