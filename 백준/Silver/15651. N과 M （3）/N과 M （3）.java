import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        answer = new int[m];
        sb = new StringBuilder();
        DFS(0);
        System.out.println(sb.toString());
    }

    public static void DFS(int depth) {
        if (depth == m) {
            for (int i : answer) sb.append(i + " ");
            sb.append('\n');
            return;
        }

        // n 만큼 경우의 수를 체크
        for (int i=0; i<n; i++) {
            answer[depth] = i+1;
            DFS(depth+1);
        }
    }
}
