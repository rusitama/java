import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Seminar2_homework1
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class Seminar2_homework1 {

    public static void main(String[] args) throws ParseException {
        StringBuilder sb = new StringBuilder();
        String query = "select * from students where ";
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;

        sb.append(query);
        boolean isWhere = false;
        for (Object keySet : jsonObj.keySet()) {
            if (!isWhere){
                if (!jsonObj.get(keySet).equals("null")){
                    sb.append(" where " + keySet.toString() + " = " + jsonObj.get(keySet));
                    isWhere = true;
                }
            }
            else{
                if (!jsonObj.get(keySet).equals("null"))
                    sb.append(" and " + keySet.toString() + " = " + jsonObj.get(keySet));
            }           
        }
        System.out.println(sb);

    }
   
}