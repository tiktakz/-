
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m, n, count;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<Node> q = new LinkedList<>();

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                // 방문하지 않고 토마토인 경우에만 퍼뜨림
                if (graph[i][j] == 1 && !visited[i][j]) {
                    q.offer(new Node(i, j));
                    // 미리 큐에 넣지 않고 BFS를 수행하면 나머지 배열 입력받기 전에 시작하기 때문에
                    // 이상한 결과가 나오기 때문에 우선 입력을 다 받고 시작 위치만 저장해놓고 한번에 BFS 수행
                }
            }
        }
        BFS();
        int max = Integer.MIN_VALUE;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (max < graph[i][j]) max = graph[i][j];
            }
        }
        System.out.println(max - 1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int cx = currentNode.x;
            int cy = currentNode.y;
            visited[cx][cy] = true;

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 옆에 안익은 토마토가 있으면 익게해
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[cx][cy] + 1;
                        q.offer(new Node(nx,ny));
                    }
                }
            }
        }
    }
}
