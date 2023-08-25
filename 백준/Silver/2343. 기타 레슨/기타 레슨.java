
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 담아야할 시간은 9분짜리(제일 긴 시간이 9분이니까..)
        // 최대 담을 수 있는 시간은 45분(레슨 시간의 총합)
        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();

        while (start <= end) {
            int sum = 0;
            int dvd = 0;
            int mid = (start + end) / 2;
            for (int i=0; i<n; i++) {
                if (sum + arr[i] > mid) {
                    sum = 0;
                    dvd++;
                }
                sum += arr[i];
            }
            if (sum != 0) dvd++;
            if (dvd > m) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        System.out.println(start);

    }
}
