import java.util.*;

public class Main {
    static int n;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static char[][] graph;

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
        visited = new boolean[n][n];
        graph = new char[n][n];
        for (int i=0; i<n; i++) {
            String str = sc.next();
            for (int j=0; j<n; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    count++;
                    BFS(i,j);
                }
            }
        }

        visited = new boolean[n][n];
        int count2 = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 'G') {
                    graph[i][j] = 'R';
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    count2++;
                    BFS(i, j);
                }
            }
        }

        System.out.println(count + " " + count2);

    }

    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            for (int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (graph[nx][ny] == graph[current.x][current.y] && !visited[nx][ny]) {
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
