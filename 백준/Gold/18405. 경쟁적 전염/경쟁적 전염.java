
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int x, y, index, time;
    public Node(int x, int y, int index, int time) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        if (o.time == this.time) {
            return this.index - o.index;
        }
        return this.time - o.time;
    }
}

public class Main {
    static int n,k,s,x,y;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        pq = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0) {
                    pq.offer(new Node(i, j, graph[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        BFS();
        System.out.println(graph[x-1][y-1]);
    }

    public static void BFS() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        // Queue<Node> q = new LinkedList<>();
        // 우선순위 큐를 사용했으니 뽑으면 우선 가장 작은 바이러스부터 시작
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.time == s) {
                return;
            }

            for (int i=0; i<4; i++) {
                // 바이러스와 연결된 다른 좌표를 확인
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 다음칸이 0이여야 갈 수 있음. 0이 아닌경우는 이미 다른 바이러스가 있는것이기 때문에 못감
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = current.index; // 같은 바이러스로 전파해야함.
                        pq.offer(new Node(nx, ny, current.index, current.time + 1));
                    }
                }
            }
        }
    }
}
