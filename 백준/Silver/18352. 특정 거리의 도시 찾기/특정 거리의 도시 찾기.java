
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cities, roads, distance, start, count;
    static ArrayList<ArrayList<Integer>> graph;
    static int visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cities = Integer.parseInt(st.nextToken());
        roads = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new int[cities+1];
        /*
        4 5 3 1
        1 2
        1 3
        2 3
        2 4
        4 1
        정답 -1

        방문을 0으로 초기화한다면, 위의 입력인 경우 자기 자신으로 4 -> 1로 가는 거리가 3이라고 나오니 답은 1이 나온다.
        왜냐하면 bfs에서 다음 노드가 0인 경우 (즉 방문 안햇을 때) 방문하게 되어있지만, 문제에서 X 에서 X로 가는 최단 거리는 0이라고 했기 때문에
        갱신 하면 안됨. 그렇기 때문에 초기화를 0으로 하면 안됨.
         */
        Arrays.fill(visited, -1);
        graph = new ArrayList<>();
        for (int i=0; i<=cities; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i=0; i<roads; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        BFS(start);
        boolean check = false;
        for (int i=0; i<visited.length; i++) {
            if (visited[i] == distance) {
                System.out.println(i);
                check = true;
            }
        }
        if (!check) System.out.println(-1);
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 0; // 자기 자신의 거리는 0
        q.offer(start);

        while (!q.isEmpty()) {
            int city = q.poll();
            for (int i=0; i<graph.get(city).size(); i++) {
                int nextCity = graph.get(city).get(i);
                if (visited[nextCity] == -1) {
                    visited[nextCity] = visited[city] + 1;
                    q.offer(nextCity);
                }
            }
        }
    }
}
