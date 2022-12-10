import java.util.Scanner;

/**
 * Seminar1_homework3
 * Реализовать простой калькулятор
 */
public class Seminar1_homework3 {

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        Scanner iScanner = new Scanner(System.in);
        if(iScanner.hasNextInt()){
            num = iScanner.nextInt();            
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            //Scanner iScanner = new Scanner(System.in);
            iScanner.next(); //рекурсия
            num = getInt();
        } 
        //iScanner.close();       
        return num;        
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        Scanner iScanner = new Scanner(System.in);
        if (iScanner.hasNext()) {
            operation = iScanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            iScanner.next(); // рекурсия
            operation = getOperation();
        }
        //iScanner.close(); 
        return operation;       
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation()); // рекурсия
        }
        return result;
    }
}
