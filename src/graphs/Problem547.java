package graphs;

public class Problem547 {
    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        int[] visited = new int[n];
        for (int v = 0; v < n; v++) {
            if (visited[v] != 1) {
                dfs(isConnected, v, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] graph, int to, int[] visited) {
        visited[to] = 1;

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 1 && graph[to][i] == 1) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(test));
    }

}
