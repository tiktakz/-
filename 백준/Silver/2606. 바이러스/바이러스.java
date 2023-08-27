
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int computers, networks;
    static int virusComputers;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        computers = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        networks = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[computers+1];

        for (int i=0; i<=computers; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<networks; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        virusComputers = 0;
        DFS(1);
        System.out.println(virusComputers);
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int i=0; i<graph.get(start).size(); i++) {
            int nextComputer = graph.get(start).get(i);
            if (!visited[nextComputer]) {
                virusComputers++;
                visited[nextComputer] = true;
                DFS(nextComputer);
            }
        }
    }
}
