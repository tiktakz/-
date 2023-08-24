
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] find = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //Arrays.sort(find);

        for (int i=0; i<m; i++) {
            int p1 = 0;
            int p2 = n-1;
            int target = find[i];
            System.out.println(search(arr,p1,p2,target) ? 1 : 0);
        }
    }

    private static boolean search(int[] arr, int p1, int p2, int target) {
        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            if (arr[mid] == target) {
                return true;
            }
            else if (arr[mid] > target) {
                p2 =  mid - 1;
            }
            else if (arr[mid] < target) {
                p1 = mid + 1;
            }
        }
        return false;
    }
}
