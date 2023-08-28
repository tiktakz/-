import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, answer;
    static int[][] graph;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Node {
        int x, y, distance;
        boolean destroyed;
        public Node(int x, int y, int distance, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.destroyed = destroyed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken().toString();
            for (int j=0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // (0,0) 부터 시작하고 처음 움직이는 거리는 1, 처음에는 벽을 안부숨
        System.out.println(BFS(0, 0, 1, false));
    }

    public static int BFS(int x, int y, int distance, boolean destroyed) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,distance, destroyed));

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            // 만약 좌표의 끝 (N-1)(M-1)에 도착하면 몇칸 이동했는지 출력
            if (currentNode.x == n-1 && currentNode.y == m-1) {
                return currentNode.distance;
            }

            // 그렇지 않으면 상하좌우 탐색하면서 갈 수 있는 곳을 탐색한다
            for (int i=0; i<4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                // 범위에 맞는지 확인
                // 1. 범위 이탈이면 넘어가서 다음 위치 확인
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (graph[nx][ny] == 0) {
                    if (!currentNode.destroyed && !visited[nx][ny][0]) {
                        q.offer(new Node(nx, ny, currentNode.distance+1, false));
                        visited[nx][ny][0] = true;
                    }
                    else if (currentNode.destroyed && !visited[nx][ny][1]) {
                        q.offer(new Node(nx, ny, currentNode.distance+1, true));
                        visited[nx][ny][1] = true;
                    }
                }
                else if (graph[nx][ny] == 1) {
                    if (!currentNode.destroyed) {
                        visited[nx][ny][1] = true;
                        q.offer(new Node(nx, ny, currentNode.distance+1, true));
                    }
                }
            }
        }
        return -1;
    }
}
