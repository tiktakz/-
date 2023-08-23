import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, v;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m  = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=0; i<=n; i++) {
            Collections.sort(graph.get(i));
        }

        DFS(v);
        Arrays.fill(visited, false);
        System.out.println();
        BFS(v);
    }

    public static void DFS(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i=0; i<graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            if (!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            for (int i=0; i<graph.get(n).size(); i++) {
                int next = graph.get(n).get(i);
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
