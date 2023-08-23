
import java.util.*;

class Main {
    // t: testcase, m:가로, n:세로, k:배추개수
    static int t, m, n, k, nx, ny;
    static boolean[][] visited;
    static int[][] graph;
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};

    public static void DFS(int x, int y) {
//        if (x<0 || y<0 || x>m || y>n) return; // 범위 밖
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<m && ny<n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt(); // Testcase numbers
        for (int i=0; i<t; i++) {
            m = sc.nextInt(); // 가로
            n = sc.nextInt(); // 세로
            k = sc.nextInt(); // 배추
            graph = new int[m][n];
            visited = new boolean[m][n];
            for (int j=0; j<k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
            }
            int count = 0;
            for (int p=0; p<m; p++) {
                for (int l=0; l<n; l++) {
                    if (graph[p][l] == 1 && !visited[p][l]) {
                        DFS(p,l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
