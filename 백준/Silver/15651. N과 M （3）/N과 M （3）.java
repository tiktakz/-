import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] answer;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        check = new boolean[n];
        answer = new int[m];

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
        sc.close();
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=0; i<n; i++) {
                answer[depth] = arr[i];
                dfs(depth + 1);
            }
        }
    }
