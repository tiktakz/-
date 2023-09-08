import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i=0; i<n; i++) {
            String str = sc.next();
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        for (int i=0; i<m; i++) {
            String str = sc.next();
            if (hm.get(str) != null) {
                count++;
            }
        }

        System.out.println(count);
    }
}
