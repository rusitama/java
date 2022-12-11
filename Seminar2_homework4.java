
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.*;

/**
 * Seminar2_homework4
 * К калькулятору из предыдущего дз добавить логирование.
 */
public class Seminar2_homework4 {

    static Logger LOGGER;
    static {
        try (FileInputStream ins = new FileInputStream("log.config")) {
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Seminar2_homework4.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int num1 = getInt("");
        int num2 = getInt("");
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Результат операции: " + result);

        try {
            LOGGER.log(Level.INFO, "Result of operation: " + result);

        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "somthing wrong", e);
        }
    }

    public static int getInt(String str) throws Exception {
        System.out.println("Введите число:");
        int num;
        Scanner iScanner = new Scanner(System.in);
        if (iScanner.hasNextInt()) {
            num = iScanner.nextInt();
            try {
                LOGGER.log(Level.INFO, "int: " + num);
    
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "somthing wrong", e);
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            try {
                LOGGER.log(Level.WARNING, "Not int");
    
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "somthing wrong", e);
            }
            iScanner.next(); // рекурсия
            num = getInt(str);
        }
        if (str == " ")
            iScanner.close();
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        Scanner iScanner = new Scanner(System.in);
        if (iScanner.hasNext()) {
            operation = iScanner.next().charAt(0);
            try {
                LOGGER.log(Level.INFO, "Operation: " + operation);
    
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "somthing wrong", e);
            }
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            try {
                LOGGER.log(Level.WARNING, "It is not operation");
    
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "somthing wrong", e);
            }
            iScanner.next(); // рекурсия
            operation = getOperation();
        }
        iScanner.close();
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