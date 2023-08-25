
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i=n-1; i>=0; i--) {
            if (coins[i] <= k) {
                // 목표금액보다 동전이 작으면 사용가능
                count = count + (k / coins[i]); // 해당 금액을 목표로 나누면 몇개 필요한지 나옴
                k = k % coins[i];
            }
        }
        System.out.println(count);
    }
}
