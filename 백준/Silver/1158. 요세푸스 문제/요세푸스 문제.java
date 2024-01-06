
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            al.add(i);
        }

        int[] answer = new int[n];
        int currentIndex = 0;

        for (int i=0; i<n; i++) {
            currentIndex = (currentIndex + k - 1) % al.size();
            answer[i] = al.remove(currentIndex);
        }

        System.out.print("<");
        for (int i=0; i<n; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(answer[i]);
        }
        System.out.println(">");
    }
}
