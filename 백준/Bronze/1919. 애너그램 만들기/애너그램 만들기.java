
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (char c : str1.toCharArray()) {
            arr1[c-'a']++;
        }

        for (char c : str2.toCharArray()) {
            arr2[c-'a']++;
        }

        int answer = 0;
        for (int i=0; i<26; i++) {
            answer += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(answer);
    }
}
