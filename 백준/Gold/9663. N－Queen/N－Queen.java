import java.util.Scanner;

public class Main {
    static int n, count;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        DFS(0);
        System.out.println(count);
    }

    public static void DFS(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i=0; i<n; i++) {
            arr[depth] = i;
            if (check(depth)) {
                DFS(depth + 1);
            }
        }
    }

    public static boolean check(int num) {
        for (int i=0; i<num; i++) {
            if (arr[i] == arr[num]) {
                return false;
            }

            else if (Math.abs(num - i) == Math.abs(arr[num] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
