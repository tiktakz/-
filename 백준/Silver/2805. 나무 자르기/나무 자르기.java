

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean canCut(int[] trees, int cutter, int m)  {
        long sum = 0;
        for (int tree : trees) {
            if (tree >= cutter) {
                sum += tree - cutter;
            }
        }
        return sum >= m ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] trees = new int[n];
        for (int i=0; i<n; i++) {
            trees[i] = sc.nextInt();
        }

        int lp = 0;
        int rp = Arrays.stream(trees).max().getAsInt();
        int answer = 0;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (canCut(trees, mid, m)) {
                answer = mid;
                lp = mid + 1;
            }
            else {
                rp = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
