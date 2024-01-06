
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.next();
        List<Character> list = new LinkedList<>();
        for (char alph : original.toCharArray()) {
            list.add(alph);
        }

        int m = sc.nextInt();
        ListIterator<Character> it = list.listIterator(list.size()); // 맨 뒤에 cursor

        while (m -- > 0) {
            char cmd = sc.next().charAt(0);
            switch (cmd) {
                case 'L':
                    if (it.hasPrevious()) it.previous();
                    break;
                case 'D':
                    if (it.hasNext()) it.next();
                    break;
                case 'B':
                    if (it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case 'P':
                    it.add(sc.next().charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char alph : list) {
            sb.append(alph);
        }
        System.out.println(sb.toString());

    }
}
