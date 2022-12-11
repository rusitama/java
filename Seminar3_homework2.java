import java.util.ArrayList;

/**
 * Seminar3_homework2
 * Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class Seminar3_homework2 {

    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5};
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 1; i < 6; i++) {
            array.add(i);
        }
        printArray("Данн массив:", array);
 
        array = deleteEvenElement(array);
        printArray("Результат:", array);
 
    }
 
    public static void printArray(String text, ArrayList<Integer> array) {
        System.out.print(text + " [");
        for (int i = 0; i < array.size() - 1; i++) {
            System.out.print(array.get(i) + ", ");
        }
        System.out.println(array.get(array.size() - 1) + "]");
    }
 
    public static ArrayList<Integer> deleteEvenElement(ArrayList<Integer> array) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < array.size() ; i++) 
             if (array.get(i) % 2 != 0)
                 arr.add(array.get(i));        
        return arr;
    }
}