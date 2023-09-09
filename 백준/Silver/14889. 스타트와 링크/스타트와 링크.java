import java.util.Scanner;

public class Main {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    public static void DFS(int index, int depth) {
        if (depth == n/2) {
            compareStats();
            return;
        }

        for (int i=index; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i+1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void compareStats() {
        // 두 팀으로 나누기 때문에 n/2 만큼은 true, 나머지는 false
        // true이면 1번팀, false면 2번팀
        int starTeam = 0;
        int linkTeam = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (visited[i] == true && visited[j] == true) {
                    starTeam += graph[i][j];
                    starTeam += graph[j][i];
                }
                else if (visited[i] == false && visited[j] == false) {
                    linkTeam += graph[i][j];
                    linkTeam += graph[j][i];
                }
            }
        }

        int difference = Math.abs(starTeam - linkTeam);
//        if (difference == 0) {
//            System.out.println(difference);
//            System.exit(0);
//        }

        answer = Math.min(answer, difference);
    }
}
