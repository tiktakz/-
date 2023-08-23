import java.util.*;

class Main {
    static int[] map;
    static int[] operations = new int[4];
    static int n;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n];

        for (int i=0; i<n; i++) {
            map[i] = sc.nextInt();
        }

        for (int i=0; i<4; i++) {
            operations[i] = sc.nextInt();
        }

        DFS(map[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void DFS(int number, int depth) {
        if (depth == n) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);
            return;
        }

        for (int i=0; i<4; i++) {
            if (operations[i] > 0) {
                operations[i]--;
                switch (i) {
                    case 0:
                        DFS(number + map[depth], depth + 1);
                        break;
                    case 1:
                        DFS(number - map[depth], depth + 1);
                        break;
                    case 2:
                        DFS(number * map[depth], depth + 1);
                        break;
                    case 3:
                        DFS(number / map[depth], depth + 1);
                        break;
                }
                operations[i]++;
            }
        }
    }
}
