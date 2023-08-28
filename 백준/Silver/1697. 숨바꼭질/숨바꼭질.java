import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] graph = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] moves = {-1, 1, 2};
    static int n, k;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;
                if (n == k) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        graph[n] = 1;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int i=0; i<3; i++) {
                int nx;
                if (i == 2) {
                    nx = tmp * 2;
                }
                else {
                    nx = tmp + moves[i];
                }

                if (nx == k) {
                    System.out.println(graph[tmp]);
                    return;
                }

                if (nx >= 0 && nx < graph.length && graph[nx] == 0) {
                    graph[nx] = graph[tmp] + 1;
                    q.offer(nx);
                }
            }
        }
    }
}
