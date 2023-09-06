import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] graph;
    static boolean[][] visited;

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // 일단 물이 어디까지 차는지 확인해야함
        // 그럼 1부터 물의 최대높이까지 돌면서 최대값 찾아봄

        int maxRain = graph[0][0];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] > maxRain) {
                    maxRain = graph[i][j];
                }
            }
        }

        int answer = 1;
        for (int i=1; i<=maxRain; i++) {
            int safeZones = 0;
            visited = new boolean[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (!visited[j][k] && graph[j][k] > i) {
                        safeZones++;
                        BFS(j, k, i);
                    }
                }
            }
            answer = Math.max(safeZones,answer);
        }

        System.out.println(answer);
    }

    public static void BFS(int x, int y, int maxRain) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny] && graph[nx][ny] > maxRain) {
                        q.offer(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
