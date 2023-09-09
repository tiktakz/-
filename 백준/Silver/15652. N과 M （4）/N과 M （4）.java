import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        answer = new int[m];
        DFS(0,0);
    }

    public static void DFS(int start, int depth) {
        if (depth == m) {
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
            return;
        }

        // n 만큼 경우의 수를 체크
        for (int i=start; i<n; i++) {
            answer[depth] = i + 1;
            DFS(i, depth+1);
        }
    }
}
