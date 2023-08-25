
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int zero = 0;
        int one = 0;
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num > 1) {
                positive.offer(num);
            }
            else if (num == 0) {
                zero++;
            }
            else if (num == 1) {
                one++;
            }
            else {
                negative.offer(num);
            }
        }
        int sum = 0;

        // 양수 큐에 있는 숫자 두개를 가져와서 곱함
        while (positive.size() > 1) {
            int a = positive.poll();
            int b = positive.poll();
            int tmp = a * b;
            sum += tmp;
        }

        // 양수 큐의 사이즈가 홀수개이면 나머지 숫자 하나는 그냥 더해줌
        if (!positive.isEmpty()) {
            sum += positive.poll();
        }

        // 음수의 경우 양수처럼 곱하고 홀수개면 해당 숫자는 0이랑 곱해줌
        while (negative.size() > 1) {
            int a = negative.poll();
            int b = negative.poll();
            int tmp = a * b;
            sum += tmp;
        }

        if (!negative.isEmpty()) {
            if (zero == 0) {
                sum += negative.poll();
            }
        }

        sum += one;
        System.out.println(sum);
    }
}
