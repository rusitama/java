import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.ElementScanner6;

/**
 * Seminar5_homework2
 * Пусть дан список сотрудников:
 * Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова,
 * Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина
 * Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова,
 * Иван Мечников, Петр Петин, Иван Ежов
 * Написать программу, которая найдет и выведет повторяющиеся имена с
 * количеством повторений.
 * Отсортировать по убыванию популярности.
 */
public class Seminar5_homework2 {

    static String[] emploers = { "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова",
            "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
            "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин",
            "Иван Ежов" };

    public static void main(String[] args) {
        Map<String, Integer> emp = new HashMap<>();
        for (int i = 0; i < emploers.length; i++){
            String[] tempArray = (String[]) emploers[i].split(" ");
            //System.out.println(tempArray[0]);
            if (emp.get(tempArray[0]) == null)
                emp.put(tempArray[0], 1);
            else{
                int num = emp.get(tempArray[0]);
                emp.replace(tempArray[0], num + 1);
            }
        }

        // for (Map.Entry m : emp.entrySet()){
        //     System.out.println(m.getKey() + " " + m.getValue());
        // }
        emp.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println); // или любой другой конечный метод
    }
}