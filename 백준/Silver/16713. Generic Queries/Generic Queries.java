import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] xor = new int[n + 1];
        for (int i=1; i<=n; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }

        int answer = 0;
        while (q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            answer ^= xor[e] ^ xor[s - 1];
        }
        System.out.println(answer);
    }
}
