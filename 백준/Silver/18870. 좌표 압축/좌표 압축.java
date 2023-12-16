
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] coord = new int[n][2];
        for (int i=0; i<n; i++) {
            coord[i][0] = sc.nextInt();
            coord[i][1] = i;
        }

        Arrays.sort(coord, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int index = 0;
        int[] answer = new int[n];
        answer[coord[0][1]] = index;
        for (int i=1; i<n; i++) {
            if (coord[i][0] != coord[i-1][0]) {
                index++;
            }
            answer[coord[i][1]] = index;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
