import java.util.*;

class Main {
    public static int min = 64;
    public static boolean[][] board;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        board = new boolean[m][n];
        sc.nextLine();
        for (int i=0; i<m; i++) {
            String tmp = sc.next();
            for (int j=0; j<n; j++) {
                if (tmp.charAt(j) == 'W') {
                    board[i][j] = true;
                }
                else {
                    board[i][j] = false;
                }
            }
        }
        
        for (int i=0; i<m-7; i++) {
            for (int j=0; j<n-7; j++) {
                find(i,j);
            }
        }
        
        System.out.println(min);
    }
    
    public static void find(int x, int y) {
        int count = 0;
        boolean color = board[x][y];
        
        for (int i=x; i<x+8; i++) {
            for (int j=y; j<y+8; j++) {
                if (board[i][j] != color) {
                    count++;
                }
                color = !color;
            }
            color = !color;
        }
        
        count = Math.min(count, 64-count);
        min = Math.min(min, count);
    }
}