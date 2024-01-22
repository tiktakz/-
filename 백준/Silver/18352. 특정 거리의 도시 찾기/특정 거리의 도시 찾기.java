
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int n, m, k, x;
    static int[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(x);

        boolean flag = false;
        for (int i=0; i<visited.length; i++) {
            if (visited[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }
        if (!flag) System.out.println(-1);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i=0; i<graph.get(current).size(); i++) {
                int nextNode = graph.get(current).get(i);
                if (visited[nextNode] == -1) {
                    visited[nextNode] = visited[current] + 1;
                    q.offer(nextNode);
                }
            }
        }
    }
}
