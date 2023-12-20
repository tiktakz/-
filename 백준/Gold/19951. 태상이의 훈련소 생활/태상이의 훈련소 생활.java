// 2023.12.20

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] delta = new int[n+2];
        while (m-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            delta[a] += k; // 변화량 증가
            delta[b+1] -= k;
        }

        int[] accDelta = new int[n + 1];
        for (int i=1; i<=n; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        for (int i=1; i<=n; i++) {
            System.out.print(arr[i] + accDelta[i] + " ");
        }
    }
}
