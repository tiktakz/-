import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static char solution(String str) {
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        char answer = '?';
        str = str.toUpperCase();


        for (int i=0; i<str.length(); i++) {
            count[str.charAt(i)-'A']++;
            if (max < count[str.charAt(i)-'A']) {
                max = count[str.charAt(i) - 'A'];
                answer = str.charAt(i);
            }
            else if (max == count[str.charAt(i) - 'A']) {
                answer = '?';
            }
        }

        return answer;
    }
}