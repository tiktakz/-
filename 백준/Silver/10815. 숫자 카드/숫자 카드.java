import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int[] check;
        int n = sc.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        check = new int[m];
        for (int i=0; i<m; i++) {
            check[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<n; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        for (int i=0; i<m; i++) {
            if (hm.get(check[i]) != null) {
                System.out.print(1 + " ");
            }
            else {
                System.out.print(0 + " ");
            }
        }
    }
}
