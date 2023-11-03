import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next();
        String drop = sc.next();
        String[] timeArray = time.split(":");
        String[] dropArray = drop.split(":");

        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        int second = Integer.parseInt(timeArray[2]);
        int currentSecondAmount = hour * 3600 + minute * 60 + second;

        int dropHour = Integer.parseInt(dropArray[0]);
        int dropMinute = Integer.parseInt(dropArray[1]);
        int dropSecond = Integer.parseInt(dropArray[2]);
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

        int needSecondAmount = dropSecondAmount - currentSecondAmount;

        if (needSecondAmount <= 0) {
            needSecondAmount += 24 * 3600;
        }

        int needHour = needSecondAmount / 3600;
        int needMinute = (needSecondAmount % 3600) / 60;
        int needSecond = needSecondAmount % 60;

        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);

    }
}
