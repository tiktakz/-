import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = n/4;

        for (int i=1; i<=count; i++) {
            System.out.print("long" + " ");
        }
        System.out.print("int");
    }
}
