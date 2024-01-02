
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int calculateLength(int[] wires, long cutLength) {
        int count = 0;
        for (int wire : wires) {
            if (cutLength != 0) {
                count += wire / cutLength;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] wires = new int[k];
        for (int i=0; i<k; i++) {
            wires[i] = sc.nextInt();
        }

        long answer = 0;
        long lp = 1;
        long rp = (1L << 31) - 1;

        while (lp <= rp) {
            long mid = (lp + rp) / 2;
            if (calculateLength(wires, mid) >= n) {
                answer = mid;
                lp = mid + 1;
            }
            else rp = mid - 1;
        }

        System.out.println(answer);
    }
}
