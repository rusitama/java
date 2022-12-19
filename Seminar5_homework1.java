import java.util.HashMap;
import java.util.Map;

/**
 * Seminar5_homework1
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1
 * человек может иметь несколько телефонов
 */
public class Seminar5_homework1 {

    static Map<String, String[]> PhoneBook = new HashMap<>();
    static String[] users = {"Вишняков Бронислав", "Беляев Емельян", "Горбачёва Мелитта", "Дроздова Нина",
            "Соловьёв Варлам", "Лебедева Христина", "Щукина Мелиана", "Горшкова Ярослава", "Емельянов Азарий",
            "Комиссаров Никифор"};

    static String[] numbers = {"888(17)017-06-27", "5(9652)118-12-94", "82(75)504-68-53", "2(603)663-78-29", 
            "1(406)719-21-39", "920(77)117-85-56", "578(2848)679-71-87", "1(2854)727-28-49", "2(1476)320-20-11", 
            "226(128)918-19-31", "5(4060)933-23-44", "7(8180)991-80-01", "3(1787)171-49-59", "76(58)698-50-66", 
            "8(4692)705-42-94"};
    static String[] numbers2 = {"5(4060)933-23-44", "7(8180)991-80-01", "3(1787)171-49-59", "76(58)698-50-66", "8(4692)705-42-94"};
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < users.length; i++){            
            if (PhoneBook.get(users[i]) == null){
                String[] numb = new String[4]; //Создадим массив до 4 элементов
                if (numbers.length >= (i + 1)){
                    numb[j] = numbers[i];
                    j++;
                }
                if (numbers2.length >= (i + 1)){
                    numb[j] = numbers2[i];
                    j++;
                }
                PhoneBook.put(users[i], numb);
                j = 0;
            }
        }

        //Печать телефонной книги
        String userName = "";
        int n = 1;
        for (Map.Entry m : PhoneBook.entrySet()){
            userName = (String) m.getKey();
            String[] pn = (String[]) m.getValue();
            for (int i = 0; i < pn.length; i++){
                if (pn[i] != null){
                System.out.println(n + ". " + userName + " " + pn[i]);
                n++;
                }
            }
        }
    }
}