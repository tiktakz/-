import java.util.*;
import java.io.*;

class Main {
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
        count = 1;
        DFS(r);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) sb.append(sequence[i]).append('\n');
        System.out.print(sb);
    }

    public static void DFS(int start) {
        visited[start] = true;
        sequence[start] = count;
        for (int i=0; i<graph.get(start).size(); i++) {
            if (!visited[graph.get(start).get(i)]) {
                visited[graph.get(start).get(i)] = true;
                count++;
                DFS(graph.get(start).get(i));
            }
        }
    }
}
