import java.util.*;
import java.io.*;

class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] hacks;
    static boolean[] visited;
    static int computers, line;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        computers = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        // 필요한 그래프와 해킹된 배열 초기화
        for (int i=0; i<=computers; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 만들기
        for (int i=0; i<line; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        visited = new boolean[computers+1];
        hacks = new int[computers+1];

        // 컴퓨터마다 BFS를 수행해서 해킹가능 컴퓨터 구함
        for (int i=1; i<=computers; i++) {
            visited = new boolean[computers+1];
            BFS(i);
        }
        int max = Arrays.stream(hacks).max().getAsInt();
        for (int i=0; i<hacks.length; i++) {
            if (hacks[i] == max) {
                System.out.print(i + " ");
            }
        }

    }

    public static void BFS(int index) {
        Queue<Integer> q = new LinkedList<>();
        visited[index] = true;
        q.offer(index);

        while (!q.isEmpty()) {
            int cv = q.poll();
            for (int computer : graph.get(cv)) {
                if (!visited[computer]) {
                    visited[computer] = true;
                    hacks[computer] += 1;
                    q.offer(computer);
                }
            }
        }
    }
}
