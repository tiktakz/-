
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        StringTokenizer st;
        Deque<Integer> dq;

        for (int i=0; i<tc; i++) {
            String command = sc.next();
            int n = sc.nextInt();
            st = new StringTokenizer(sc.next(), "[],");
            dq = new LinkedList<>();
            // Deque에 원소 넣기
            for (int j=0; j<n; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            doCommand(dq, command);
        }
        System.out.println(sb);
    }

    public static void doCommand(Deque<Integer> dq, String command) {
        // 오른쪽으로 읽는 Deque
        boolean goRight = true;

        for (char c : command.toCharArray()) {
            if (c == 'R') {
                goRight = !goRight;
                continue;
            }

            if (goRight) {
                if (dq.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            }
            else {
                if (dq.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        makeString(dq, goRight);
    }

    private static void makeString(Deque<Integer> dq, boolean goRight) {

        sb.append("[");

        if (dq.size() > 0) {
            if (goRight) {
                sb.append(dq.pollFirst());
                while (!dq.isEmpty()) {
                    sb.append(",").append((dq.pollFirst()));
                }
            } else {
                sb.append(dq.pollLast());
                while (!dq.isEmpty()) {
                    sb.append(",").append(dq.pollLast());
                }
            }
        }
        sb.append("]").append('\n');
    }
}
