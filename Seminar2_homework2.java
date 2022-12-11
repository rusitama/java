import java.util.Arrays;

/**
 * Seminar2_homework2
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 * 
 * Как работает сортировка пузырьком?
 * Сортировка пузырьком заключается в следующем: начиная с начала массива просматриваем попарно по 2 элемента 
 * (первый со вторым, второй с третим, третий с четвертым и т.д.).
 * Если второй элемент в паре меньше первого элемента – перемещаем его на место первого, а первый на место второго. 
 * Это мы делаем для всех элементов.
 * После того, как мы дошли до конца массива (сравнили предпоследний и последний элементы и сделали обмен, если нужно), 
 * проверяем, был ли хотя бы один обмен. Если да, значит массив не отсортирован и начинаем все сначала. Повторяем такие 
 * проходы, пока не будет так, что мы проверили попарно все элементы от начала до конца, а обмена ни одного не было. 
 * Таким образом элементы с самыми маленькими значениями потихоньку перемещаются справа налево. То есть они как будто 
 * всплывают, как мыльный пузырь. Отсюда и название метода – пузырьком.
 */
public class Seminar2_homework2 {

    public static void main(String[] args) {
        
        int[] arr = new int[] {15, 3, 25, 89, 77};
 
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
 
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
}