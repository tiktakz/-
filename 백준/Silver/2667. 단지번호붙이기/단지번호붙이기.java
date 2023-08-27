
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] graph;
    static boolean[][] visited;
    static int n, count;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken().toString();
            for (int j=0; j<str.length(); j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    count = 1;
                    DFS(i,j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i : answer) System.out.println(i);
    }

    public static void DFS(int x, int y) {
        if (x < 0 || y < 0 || x > n || y > n) return;
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    DFS(nx,ny);
                    count++;
                }
            }
        }
    }
}