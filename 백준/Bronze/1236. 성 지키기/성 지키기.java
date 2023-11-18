import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] building = new char[n][m];

        for (int i=0; i<n; i++) {
            building[i] = sc.next().toCharArray();
        }

        boolean existRow[] = new boolean[n];
        boolean existCol[] = new boolean[m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (building[i][j] == 'X') {
                    existRow[i] = true;
                    existCol[j] = true;
                }
            }
        }

        int needRow = n;
        int needCol = m;

        for (int i=0; i<n; i++) {
            if (existRow[i]) {
                needRow--;
            }
        }

        for (int i=0; i<m; i++) {
            if (existCol[i]) {
                needCol--;
            }
        }

        System.out.println(Math.max(needCol, needRow));
    }
}
