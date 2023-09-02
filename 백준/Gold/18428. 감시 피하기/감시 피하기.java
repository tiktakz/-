import java.util.*;
import java.io.*;

class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Node> teacher = new ArrayList<>();
    static char[][] graph;
    static char[][] copy;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        graph = new char[6][6];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }
        DFS(0);
        System.out.println("NO");
    }

    static void print() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void DFS(int object) {
        if (object == 3) {
            if (BFS()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j] == 'X') {
                    graph[i][j] = 'O';
                    DFS(object + 1);
                    graph[i][j] = 'X';
                }
            }
        }
    }

    public static boolean BFS() {
        Queue<Node> q = new LinkedList<>();
        copy = new char[6][6];
        // 장애물 설치한 그래프 복사
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                copy[i][j] = graph[i][j];
                if (copy[i][j] == 'T') {
                    q.offer(new Node(i,j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node cv = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cv.x;
                int ny = cv.y;
                while (true) {
                    nx += dx[i];
                    ny += dy[i];
                    if (nx<0 || ny<0 || ny>=n || nx>=n) break;
                    if (copy[nx][ny] == 'O') break;
                    if (copy[nx][ny] == 'S') return false;
                }
            }
        }
        return true;
    }
}
