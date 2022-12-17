import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.*;

/**
 * Seminar4_homework3
 * В калькулятор добавьте возможность отменить последнюю операцию.
 */
public class Seminar4_homework3 {

    static LinkedList<String> Operation = new LinkedList<>();
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
        char qn;
        while (true) {
            int num1 = getInt("");
            int num2 = getInt("");
            char operation = getOperation("");
            int result = calc(num1, num2, operation);
            System.out.println("Результат операции: " + result);

            try {
                LOGGER.log(Level.INFO, "Result of operation: " + result);

            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "somthing wrong", e);
            }

            System.out.println("Хотите продолжить? Y/N.");
            Scanner iScanner = new Scanner(System.in);
            if (iScanner.hasNext()) {
                qn = iScanner.next().charAt(0);
                if (qn == 'n'){
                    for(String op : Operation)
                        System.out.println(op);
                    System.out.println("Отменить последнюю операцию? y: ");
                    qn = iScanner.next().charAt(0);
                    if (qn == 'y'){
                        Operation.removeLast();
                        for(String op : Operation)
                            System.out.println(op);
                    }
                    iScanner.close();
                    break; 
                }
            } 
        }
        
        //Operation.size();
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

    public static char getOperation(String str) {
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
            operation = getOperation(str);
        }
        if (str == " ")
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
                result = calc(num1, num2, getOperation("")); // рекурсия
        }
        Operation.add("" + num1 + " " + operation + " " + num2 + " = " + result);
        return result;
    }
}
