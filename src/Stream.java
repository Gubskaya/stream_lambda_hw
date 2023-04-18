import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 3, 4, 6);

        double average = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Среднее значение: " + average);

        List<Integer> square = numbers.stream().map(num -> num * num).toList();
        System.out.println("Список квадратов: " + square);

        List<Integer> evenNums = numbers.stream().filter(num -> num % 2 == 0).toList();
        System.out.println("Четные числа: " + evenNums);

        boolean three = numbers.stream().anyMatch(num -> num == 3);
        System.out.println("Содержит ли список число 3: " + three);

        Optional<String> string = strings.stream().reduce((str1, str2) -> str1 + ", " + str2);
        System.out.println("Элементы списка в одну строку через запятую: " + string.get());

        List<Integer> firstThreeNum = numbers.stream().limit(3).toList();
        System.out.println("Первые три элемента списка: " + firstThreeNum);

        List<Integer> distinct = numbers2.stream().distinct().toList();
        System.out.println("Уникальные значения: " + distinct);

        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Максимальное значение: " + max.get());

        List<Integer> sorted = numbers.stream().sorted(Collections.reverseOrder()).toList();
        System.out.println("Список в обратном порядке: " + sorted);


    }
}
