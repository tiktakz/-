
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken().toString();
        String[] str1 = str.split("-");
        int sum = 0;

        for (int i=0; i<str1.length; i++) {
            int n = partSum(str1[i]);
            if (i == 0) {
                sum += n;
            }
            else {
                sum -= n;
            }
        }
        System.out.println(sum);
    }

    public static int partSum(String str) {
        int sum = 0;
        String[] tmp = str.split("[+]");
        for (String s : tmp) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
