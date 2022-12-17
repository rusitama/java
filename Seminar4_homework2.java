import java.util.LinkedList;

/**
 * Seminar4_homework2
 * Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() -
 * помещает
 * элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и
 * удаляет его,
 * first() - возвращает первый элемент из очереди, не удаляя.
 */
public class Seminar4_homework2 {
    public static LinkedList<String> cities = new LinkedList<>();

    public static void main(String[] args) {
        String[] city = { "Tokyo", "Delhi", "Shanghai", "San Paulo", "Mexico City", "Cairo",
                "Mumbai", "Beijing", "Dhaka", "Osaka", "New York", "Karachi", "Buenos Aires" };

        for (int i = 0; i < city.length; i++) {
            cities.add(city[i]);
        }

        System.out.println("Дан список");
        printLinkedList();

        System.out.println("Метод добавления в конец листа");
        enqueue();
        printLinkedList();

        System.out.println("Метод удаляет из начала листа и добавляет в конец");
        dequeue();
        printLinkedList();

        System.out.println("Метод получает первый элемент из листа и добавляет в конец");
        first();
        printLinkedList();
    }

    public static void enqueue() {
        cities.addLast("Moskva");
    }

    public static void dequeue() {
        String city = cities.get(0);
        cities.removeFirst();
        cities.addLast(city);
    }

    public static void first() {
        String city = cities.get(0);
        cities.addLast(city);
    }

    public static void printLinkedList() {
        String lCity = "";
        int i = 0;
        for (String sity : cities) {
            if (i == 0) {
                lCity = sity;
                i++;
            } else
                lCity = lCity + ", " + sity;
        }
        System.out.println(lCity + "\n");
    }
}
