/**
 * Seminar1_homework1
 * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
 */
public class Seminar1_homework1 {

    public static void main(String[] args) {
        String sum = showTotalAmount(6);
        System.out.println(sum);
    }

    public static String showTotalAmount(int value) {
        int result = 0;
        for (int i = 1; i <= value; i++) {
            result += factorial(i);
        }
        return String.valueOf(result);
    }

    public static int factorial(int value){
        int result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        //System.out.println(value + " дает значение " + result);
        return result;
    }
}