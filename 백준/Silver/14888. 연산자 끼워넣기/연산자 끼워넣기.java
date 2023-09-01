
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] arr;
    static int[] operations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        operations = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            // 순서 + - * /
            operations[i] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 숫자 부터 시작
        DFS(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    public static void DFS(int start, int depth) {
        if (depth == n) {
            // 깊이가 n은 모든 숫자를 다 돌았다는 뜻
            min = Math.min(min, start);
            max = Math.max(max, start);
        }

        for (int i=0; i<4; i++) {
            // 해당 연산 부호가 남아있으면
            if (operations[i] > 0) {
                operations[i]--; // 연산 하나 처리
                switch(i) {
                    case 0:
                        DFS(start + arr[depth], depth+1);
                        break;
                    case 1:
                        DFS(start - arr[depth], depth+1);
                        break;
                    case 2:
                        DFS(start * arr[depth], depth+1);
                        break;
                    case 3:
                        DFS(start / arr[depth], depth+1);
                        break;
                }
                operations[i]++;
            }
        }
    }

}
