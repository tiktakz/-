

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
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Arrays.stream(arr).max().getAsInt();
        int end = Arrays.stream(arr).sum();
        int answer = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }
        System.out.println(answer);
    }

    private static int count(int[] arr, int capacity) {
        int sum = 0;
        int blueray = 1;
        for (int i : arr) {
            if (sum + i > capacity) {
                blueray++;
                sum = i;
            }
            else sum += i;
        }
        return blueray;
    }
}
