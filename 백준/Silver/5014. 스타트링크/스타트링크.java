import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int f,s,u,g,d;
    static int[] floors;
    static boolean[] visited;
    static int[] moves;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt();
        s = sc.nextInt();
        g = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        moves = new int[] {u, -d};
        floors = new int[f + 1];
        visited = new boolean[f + 1];
        BFS(s);
    }

    public static void BFS(int currentFloor) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        floors[currentFloor] = 0;
        visited[currentFloor] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == g) {
                System.out.println(floors[current]);
                return;
            }

            for (int i=0; i<2; i++) {
                int nextMove = current + moves[i];

                if (nextMove >= 1 && nextMove <= f) {
                    if (!visited[nextMove]) {
                        visited[nextMove] = true;
                        floors[nextMove] = floors[current] + 1;
                        q.offer(nextMove);
                    }
                }
            }
        }
        System.out.println("use the stairs");
    }
}
