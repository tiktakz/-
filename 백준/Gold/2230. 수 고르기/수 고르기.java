
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        // 정렬해서 차이를 구하면 pt2가 증가할수록 차이가 커짐
        // 즉 그 이전의 값이 m보다 작은애들은 볼 필요가 없음
        Arrays.sort(arr);

        // Minimum value...
        int answer = Integer.MAX_VALUE;
        // 차이는 M 보다 크면 됨.

        int pt2 = 0;

        for (int pt1=0; pt1<n; pt1++) {
            while (arr[pt2] - arr[pt1] < m && pt2 < n - 1) {
                // 차이가 m보다 작으면 계속 증가시켜주고, pt2의 범위는 배열사이즈
                pt2++;
            }
            int difference = arr[pt2] - arr[pt1];
            if (difference >= m) answer = Math.min(answer, difference);
        }

        System.out.println(answer);
    }
}
