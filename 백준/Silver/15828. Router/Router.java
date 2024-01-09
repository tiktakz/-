
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> buffer = new LinkedList<>();

        while (true) {
            int command = sc.nextInt();
            if (command == -1) break;

            if (buffer.size() < n && command > 0) {
                buffer.offer(command);
            }

            if (command == 0) {
                buffer.poll();
            }
        }


        if (buffer.size() == 0) System.out.println("empty");
        else {
            for (int i : buffer) {
                System.out.print(i + " ");
            }
        }
    }
}
