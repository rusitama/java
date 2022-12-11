import java.util.ArrayList;
import java.util.Random;

/**
 * Seminar3_homework3
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и
 * среднее из этого списка.
 */
public class Seminar3_homework3 {
    public static void main(String[] args) {
        int n = 10;
        Random rand = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>(); 
        
        for (int i = 0; i < n; i++) {
            array.add(rand.nextInt(100));
        }

        printArray("Результат:", array);

        int max = array.get(0); // Массив не должен быть пустым
        int min = array.get(0);
        double avg = 0;
        for (int i = 0; i < array.size(); i++) {
            if (max < array.get(i))
                max = array.get(i);
            if (min > array.get(i))
                min = array.get(i);
            avg += (float) array.get(i) / array.size();
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }

    public static void printArray(String text, ArrayList<Integer> array) {
        System.out.print(text + " [");
        for (int i = 0; i < array.size() - 1; i++) {
            System.out.print(array.get(i) + ", ");
        }
        System.out.println(array.get(array.size() - 1) + "]");
    }

}