import java.util.*;

class Main {
    static int n,m,distance,start;
    static int[] city;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distance = sc.nextInt();
        start = sc.nextInt();

        graph = new ArrayList<>();
        visited = new boolean[n+1];
        city = new int[n+1];

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        BFS(start);

        boolean check = false;
        for (int i=1; i<=n; i++) {
            if (city[i] == distance) {
                System.out.println(i);
                check = true;
            }

        }
        if (!check) System.out.println("-1");
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        city[start] = 0; // 첫번째 시작 도시의 거리 0
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int cx = q.poll();
            for (int i=0; i<graph.get(cx).size(); i++) {
                int cv = graph.get(cx).get(i);
                if (!visited[cv]) {
                    visited[cv] = true;
                    city[cv] = city[cx] + 1;
                    q.offer(cv);
                }
            }
        }
    }

}
