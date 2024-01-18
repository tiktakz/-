

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n,m;
    static boolean[] check;
    static int[] output;
    static int[] arr;

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

        recur(0);
        sc.close();
    }

    public static void recur(int depth) {
        StringBuilder sb = new StringBuilder();
        if (depth == m) {
            for (int i=0; i<m; i++) {
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i=0; i<n; i++) {
            if (!check[i]) {
                check[i] = true;
                output[depth] = arr[i];
                recur(depth + 1);
                check[i] = false;
            }
        }
    }
}
