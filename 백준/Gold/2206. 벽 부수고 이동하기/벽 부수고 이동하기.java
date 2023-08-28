import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x, y, dist,pop;
        public Node(int x, int y, int dist, int pop) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.pop = pop;
        }
    }
    
    static int answer = Integer.MAX_VALUE;
    static int n,m;
    static int[][] visited;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        visited = new int[n][m];
        
        for (int i=0; i<n; i++) {
            String tmp = br.readLine();
            for (int j=0; j<m; j++) {
                graph[i][j] = tmp.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0,0,1,0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
    
    public static void bfs(int x, int y, int dist, int pop) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1,0));
        visited[x][y] = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.x == n-1 && node.y == m-1) {
                answer = node.dist;
                return;
            }
            
            for (int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                
                if (nx<0 || ny<0 || nx>=n || ny>=m) continue;
                if (visited[nx][ny] <= node.pop) continue;
                
                if (graph[nx][ny] == 0) {
                    q.offer(new Node(nx,ny,node.dist+1, node.pop));
                    visited[nx][ny] = node.pop;
                }
                else {
                    if (node.pop == 0) {
                        q.offer(new Node(nx,ny,node.dist+1, node.pop+1));
                        visited[nx][ny] = node.pop+1;
                    }
                }
            }
            
        }
    }
}