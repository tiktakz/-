import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int testcase, m, n, k, worms;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        testcase = Integer.parseInt(st.nextToken());

        for (int i=0; i<testcase; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[m][n];
            visited = new boolean[m][n];

            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
            }

            worms = 0;
            for (int x=0; x<m; x++) {
                for (int y=0; y<n; y++) {
                    if (!visited[x][y] && graph[x][y] == 1) {
                        worms++;
                        DFS(x,y);
                    }
                }
            }
            System.out.println(worms);
        }
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    DFS(nx,ny);
                }
            }
        }
    }
}
