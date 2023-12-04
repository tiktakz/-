
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int idx1, idx2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        for (int i=0; i<9; i++) {
            height[i] = sc.nextInt();
        }

        Arrays.sort(height);

        int totalSum = 0;
        for (int i=0; i<height.length; i++) {
            totalSum += height[i];
        }

        for (int i=0; i<height.length; i++) {
            totalSum -= height[i];
            for (int j=i+1; j<height.length; j++) {
                totalSum -= height[j];
                if (totalSum == 100) {
                    idx1 = i;
                    idx2 = j;
                    break;
                }
                totalSum += height[j];
            }
            totalSum += height[i];
        }

        for (int i=0; i<9; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            }
            System.out.println(height[i]);
        }
    }
}
