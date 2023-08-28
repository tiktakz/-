
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    static int testcase, size;

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
        testcase = Integer.parseInt(st.nextToken());

        for (int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            graph = new int[size+1][size+1];
            visited = new boolean[size+1][size+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Node start = new Node(a, b);
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            BFS(start);
            System.out.println(graph[c][d]);
        }
    }

    public static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        visited[node.x][node.y] = true;

        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            int x = currentNode.x;
            int y = currentNode.y;

            for (int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 안에 있음, 즉 유효한 칸
                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[x][y] + 1;
                        q.offer(new Node(nx,ny));
                    }
                }
            }
        }

    }
}
