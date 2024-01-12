
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(sc.readLine());
        Stack<Character> left;
        Stack<Character> right;

        for (int i = 0; i < tc; i++) {
            StringBuilder sb = new StringBuilder();
            String str = sc.readLine();
            left = new Stack<>();
            right = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) right.push(left.pop());
                }

                else if (c == '>') {
                    if (!right.isEmpty()) left.push(right.pop());
                }

                else if (c == '-') {
                    if (!left.isEmpty()) left.pop();
                }

                else left.push(c);
            }
            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            for (int j=0; j<left.size(); j++) {
                sb.append(left.elementAt(j));
            }
            System.out.println(sb.toString());
        }

        sc.close();
    }
}
