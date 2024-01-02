
import java.util.Scanner;

public class Main {

    static boolean isPossible(int[] cash, int useMoney, int cashOut) {
        int currentAmount = useMoney;
        int drawCount = 1;
        for (int use : cash) {
            if (use > useMoney) return false;
            if (use > currentAmount) {
                if (drawCount == cashOut) return false;
                drawCount++;
                currentAmount = useMoney;
            }
            currentAmount -= use;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cashOuts = sc.nextInt();
        int[] cash = new int[n];
        for (int i=0; i<n; i++) {
            cash[i] = sc.nextInt();
        }

        int lp = 1;
        int rp = n * 10000; // 제일 많은 금액은 하루에 최대 1만원이니까 날짜 * 10000
        int answer = Integer.MIN_VALUE;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (isPossible(cash, mid, cashOuts)) {
                rp = mid - 1;
                answer = mid;
            }
            else lp = mid + 1;
        }

        System.out.println(answer);
    }
}
