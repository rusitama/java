import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Seminar2_homework3
 * Дана json строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Написать метод(ы), который распарсит json и, используя StringBuilder, 
 * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * Пример вывода:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
 * https://comaqa.gitbook.io/java-automation/rabota-s-failami/rabota-s-json-failami
 */

public class Seminar2_homework3 {

    public static void main(String[] args) throws IOException, ParseException {

        JSONObject obj = new JSONObject();
        obj.put("фамилия", "Иванов");
        obj.put("оценка", 5);
        obj.put("предмет", "Математика");

        JSONObject obj2 = new JSONObject();
        obj2.put("фамилия", "Петрова");
        obj2.put("оценка", 4);
        obj2.put("предмет", "Информатика");

        JSONObject obj3 = new JSONObject();
        obj3.put("фамилия", "Краснов");
        obj3.put("оценка", 5);
        obj3.put("предмет", "Физика");

        JSONArray list = new JSONArray();
        list.add(obj);
        list.add(obj2);
        list.add(obj3);

        String fileName = "file.json";
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            writer.append(list.toJSONString());
            //writer.append("{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},"
            //                + "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},"
            //                + "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}");

        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder sb = new StringBuilder();

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileInputStream fis = new FileInputStream("file.json");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(isr)
        ) {
            String str;
            while ((str = reader.readLine()) != null) {
                Object objt = jsonParser.parse(str);
                JSONArray StdList = (JSONArray) objt;

                for (int i = 0; i <= StdList.size()-1; i++) {
                    JSONObject ob = (JSONObject) StdList.get(i);
                    sb.append("Студент " + ob.get("фамилия") + " получил " + ob.get("оценка") + " по предмету " + ob.get("предмет") + "\n");
                }
            }
    
        } catch (IOException e) {
              e.printStackTrace();
        }
        
        System.out.println(sb);

    }
}