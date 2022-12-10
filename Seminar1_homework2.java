/**
 * Seminar1_homework2
 * Вывести все простые числа от 1 до 1000
 */
public class Seminar1_homework2 {

    public static void main(String[] args) {
        System.out.println(showTotalAmount(1000));
    }

    public static String showTotalAmount(int value) {
        int result = 0;
        for (int i = 1; i <= value; i++) {
            result += i;
        }
        return String.valueOf(result);
    }
}
