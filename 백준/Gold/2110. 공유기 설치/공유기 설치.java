
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int count(int[] houses, int distance) {
        int router = 1;
        // 어디 설치? 일단 맨 앞
        int pos = houses[0];
        for (int i=0; i<houses.length; i++) {
            if (houses[i] - pos >= distance) {
                router++;
                pos = houses[i];
            }
        }
        return router;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] houses = new int[n];
        for (int i=0; i<n; i++) {
            houses[i] = sc.nextInt();
        }

        Arrays.sort(houses);

        int lp = 1;
        int rp = houses[n - 1];
        int answer = 0;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (count(houses, mid) >= c) {
                lp = mid + 1;
                answer = mid;
            }
            else {
                rp = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
