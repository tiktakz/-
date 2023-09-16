import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double subjects = 0;
        double sum = 0;

        for (int i=0; i<20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            double point = getPoint(st.nextToken());
            if (point == 9.9) continue;
            sum += point * credit;
            subjects += credit;
        }

        System.out.printf("%.5f\n", sum / subjects);

    }

    public static double getPoint(String number) {
        switch(number) {
            case "A+": return 4.5;
            case "A0": return 4.0;
            case "B+": return 3.5;
            case "B0": return 3.0;
            case "C+": return 2.5;
            case "C0": return 2.0;
            case "D+": return 1.5;
            case "D0": return 1.0;
            case "F": return 0.0;
        }
        return 9.9;
    }
}
