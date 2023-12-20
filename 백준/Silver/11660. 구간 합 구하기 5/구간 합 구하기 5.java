// 2023.12.20

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] acc = new int[n + 1][n + 1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (m-- > 0) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            bw.write(acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1] + "\n");
        }
        bw.flush();
    }
}
