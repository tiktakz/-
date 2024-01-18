
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n,m;
    static boolean[] check;
    static int[] output;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        check = new boolean[n];
        output = new int[m];

        recur(0, 0);
        System.out.println(sb);
        sc.close();
    }

    public static void recur(int depth, int start) {
        if (depth == m) {
            for (int i=0; i<m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start; i<n; i++) {
            output[depth] = arr[i];
            recur(depth + 1, i);
        }
    }
}
