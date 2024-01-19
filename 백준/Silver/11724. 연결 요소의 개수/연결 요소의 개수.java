

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        visited = new boolean[n+1];
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i=1; i<=n; i++) {
            if (!visited[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);

    }

    public static void DFS(int start) {
        if (visited[start]) return;
        visited[start] = true;

        for (int i=0; i<graph.get(start).size(); i++) {
            int nextNode = graph.get(start).get(i);
            if (!visited[nextNode]) {
                DFS(nextNode);
            }
        }
    }
}
