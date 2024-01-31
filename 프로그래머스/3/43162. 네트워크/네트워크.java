class Solution {
    static boolean[] visited;
    static int networks;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        networks = 0;   
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                networks++;
                dfs(i, computers);
            }
        }
        return networks;
    }
    
    public static void dfs(int start, int[][] computers) {
        
        for (int i=0; i<computers.length; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, computers);
            }
        }
        
    }
}