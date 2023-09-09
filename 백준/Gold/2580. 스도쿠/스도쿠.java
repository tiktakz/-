import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[9][9];
        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<9; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
    }

    public static void DFS(int x, int y) {
        // 종료 조건
        if (x == 9) {
            DFS(0, y + 1);
            return;
        }

        if (y == 9) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        // 빈 칸, 숫자가 들어갈 수 있음
        if (graph[x][y] == 0) {
            for (int i=1; i<=9; i++) {
                if (check(x, y, i)) {
                    graph[x][y] = i;
                    DFS(x+1, y);
                }
            }
            graph[x][y] = 0;
            return;
        }
        DFS(x+1, y);
    }

    public static boolean check(int x, int y, int val) {
        for (int i=0; i<9; i++) {
            if (graph[x][i] == val) {
                return false;
            }
        }

        for (int i=0; i<9; i++) {
            if (graph[i][y] == val) {
                return false;
            }
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;

        for (int i=nx; i<nx+3; i++) {
            for (int j=ny; j<ny+3; j++) {
                if (graph[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
