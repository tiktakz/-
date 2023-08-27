
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int k, v, e;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static boolean isBipartite;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        // 테스트케이스 개수만큼
        for (int i=0; i<k; i++) {
            graph = new ArrayList<>();
            isBipartite = true;
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            visited = new boolean[v+1];
            check = new boolean[v+1];
            for (int j=0; j<=v; j++) {
                graph.add(new ArrayList<>());
            }

            // edge 개수만큼 반복
            for (int l=0; l<e; l++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 모든 노드에 대해서 탐색
            for (int n=1; n<=v; n++) {
                if (isBipartite) {
                    DFS(n);
                }
                else {
                    break;
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int i=0; i<graph.get(start).size(); i++) {
            int nextNode = graph.get(start).get(i);
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                check[nextNode] = !check[start]; // false -> true, true -> false
                DFS(nextNode);
            }
            else if (visited[nextNode]) {
                if (check[nextNode] == check[start]) {
                    isBipartite = false;
                }
            }
        }
    }
}
