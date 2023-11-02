import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String answer = "";

        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                answer += ((char)('a' + ch - 'A'));
            }
            else {
                answer += ((char)('A' + ch - 'a'));
            }
        }
        System.out.println(answer);
    }
}