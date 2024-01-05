
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] required = new int[4];
    static int[] passCheck = new int[4];
    static int counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 문자열 길이
        int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        char[] dna = br.readLine().toCharArray(); // DNA 문자열
        st = new StringTokenizer(br.readLine());

        int answer = 0;

        for (int i=0; i<4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
            // {A C G T}
            if (required[i] == 0) counter++;
        }
        

        // 초기 P 문자열에 대해 비밀번호 처리
        for (int i=0; i<p; i++) {
            addCharacter(dna[i]);
        }

        // 첫 윈도우에서 비밀번호 될 수 있는지 확인
        if (counter == 4) answer++;

        for (int i=p; i<s; i++) {
            int j = i-p;
            addCharacter(dna[i]);
            removeCharacter(dna[j]);
            if (counter == 4) answer++;

            // 근데 만약 필요한 알파벳의 개수가 0이면..?
        }

        System.out.println(answer);

    }

    private static void removeCharacter (char c) {
        switch (c) {
            case 'A':
                checkIfSameRemove(0);
                passCheck[0]--;
                break;
            case 'C':
                checkIfSameRemove(1);
                passCheck[1]--;
                break;
            case 'G':
                checkIfSameRemove(2);
                passCheck[2]--;
                break;
            case 'T':
                checkIfSameRemove(3);
                passCheck[3]--;
                break;
        }
    }

    private static void addCharacter (char c) {
        switch (c) {
            case 'A':
                passCheck[0]++;
                checkIfSame(0);
                break;
            case 'C':
                passCheck[1]++;
                checkIfSame(1);
                break;
            case 'G':
                passCheck[2]++;
                checkIfSame(2);
                break;
            case 'T':
                passCheck[3]++;
                checkIfSame(3);
                break;
        }
    }

    private static void checkIfSame(int idx) {
        if (passCheck[idx] == required[idx]) counter++;
    }

    private static void checkIfSameRemove(int idx) {
        if (passCheck[idx] == required[idx]) counter--;
    }
}
