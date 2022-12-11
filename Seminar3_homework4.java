import java.util.ArrayList;
import java.util.List;

/**
 * Seminar3_homework4
 * Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так, 
 * что на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных 
 * позициях - названия книг. Напишите метод для заполнения данной структуры.
 */
public class Seminar3_homework4 {

    public static void main(String[] args) {
        
        String[] janr = {"автобиографии, биографии и мемуары", "архитектура и искусство", "астрология и эзотерика", 
                         "бизнес и финансы", "вооруженные силы", "воспитание и образование", "дом, сад, огород",
                         "здоровье", "история", "карьера", "компьютеры", "краеведение", "любовь и семейные отношения",
                         "мода и красота", "музыка, кино, радио", "наука и техника", "питание и кулинария", "подарочные издания",
                         "политика, экономика, право", "путеводители и тревелоги", "религия", "саморазвитие и психология",
                         "сельское хозяйство", "словари и энциклопедии", "спорт", "философия", "хобби", "школьные учебники", 
                         "языкознание и литература"};
        List<ArrayList<String>> books = new ArrayList<>();
        for (int i = 0; i < janr.length; i++){
            books.add(CreateBooks(janr[i], "Book " + i));
        }

        for (ArrayList<String> book : books) {
            System.out.println("Жанр " +  book.get(0) + " название книги " + book.get(1));
        }
        

    }

    public static ArrayList<String> CreateBooks(String janr, String name) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(janr);
        arr.add(name);        
        return arr;
    }

}