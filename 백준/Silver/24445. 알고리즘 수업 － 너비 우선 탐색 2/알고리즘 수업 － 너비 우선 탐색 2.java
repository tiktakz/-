
import java.util.*;
import java.io.*;

class Main {
    // BFS 탐색
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] sequence;
    public static int n, m, r, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점
        m = Integer.parseInt(st.nextToken()); // 간선
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        sequence = new int[n+1];

        for (int i=0; i<=n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i=0; i<graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }
        BFS(r);
        for (int i=1; i<=n; i++) {
            System.out.println(sequence[i]);
        }

    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>(); // BFS는 큐로 구현
        visited[start] = true; // 방문처리
        count = 1;
        sequence[start] = count++;
        q.offer(start);


        while (!q.isEmpty()) {
            int x = q.poll(); // 해당 노드 x 와 인접한 노드 탐색
            for (int i=0; i<graph.get(x).size(); i++) {
                int cv = graph.get(x).get(i);
                if (!visited[cv]) {
                    visited[cv] = true;
                    q.offer(cv);
                    sequence[cv] = count++;
                }
            }
        }
    }
}
