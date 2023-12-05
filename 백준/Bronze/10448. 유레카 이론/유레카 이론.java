import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 입력으로 주어지는 자연수의 최대값은 1,000
        // 삼각수는 총 44개만 구하면 된다
        int[] triangleNumbers = new int[45];
        for (int i=1; i<45; i++) {
            triangleNumbers[i] = i * (i + 1) / 2;
        }

        for (int i=0; i<n; i++) {
            int k = sc.nextInt();
            System.out.println(isEureka(k, triangleNumbers) ? "1" : "0");
        }
    }

    public static boolean isEureka(int k, int[] triangleNumbers) {
        for (int i=1; i<45; i++) {
            for (int j=1; j<45; j++) {
                for (int l=1; l<45; l++) {
                    int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[l];
                    if (sum == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
