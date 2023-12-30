import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static int findLowerBoundIndex(int[] arr, int x) {
        int lowerBoundIndex = arr.length;
        int l = 0;
        int r = arr.length - 1;
        
        while (l <= r) {
            int mid = (l+r) / 2;
            if (arr[mid] < x) l = mid + 1;
            else {
                r = mid - 1;
                lowerBoundIndex = mid;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x) {
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= x) l = mid + 1;
            else {
                r = mid - 1;
                upperBoundIndex = mid;
            }
        }
        return upperBoundIndex;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (m-- > 0) {
            int x = sc.nextInt();
            int lowerBoundIndex = findLowerBoundIndex(arr, x);
            int upperBoundIndex = findUpperBoundIndex(arr, x);
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
