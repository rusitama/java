import java.util.LinkedList;

/**
 * Seminar4_homework1
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
 * вернет “перевернутый” список.
 */
public class Seminar4_homework1 {
    public static LinkedList<Integer> head = new LinkedList<>();
    public static void main(String[] args) {
        int[] keys = { 1, 2, 3, 4, 5 };   
        for (int key : keys) {
            head.add(key);
        }
        printDDL("Original list: ");

        int j = 2;
        for (int i = 0; i < head.size(); i++) {
            if (j <= head.size())
                dequeue(j);
            j++;
        }

        printDDL("Reversed list: ");
    }

    // Вспомогательная функция для вывода узлов двусвязного списка
    public static void printDDL(String msg) {
        System.out.print(msg);
        for (Integer h : head) {
            System.out.print(h + " -> ");
        }
        System.out.println("null");
    }

    public static void dequeue(int j) {
        int h = head.get(head.size()-j);
        head.remove(head.size()-j);
        head.addLast(h);
    }
}
