import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.replaceAll(num -> num * 2);
        System.out.println("Список чисел умноженных на 2: " + numbers);

        BinaryOperator<Integer> sum = (x, y) -> x + y;
        System.out.println("Сумма двух чисел: " + sum.apply(7, 8));

        Predicate<Integer> isMoreThanTen = x -> x > 10;
        System.out.println("Число больше 10: " + isMoreThanTen.test(11));

        Predicate<String> isMoreThanFive = x -> x.length() > 5;
        System.out.println("Количество символов в строке больше 5: " + isMoreThanFive.test("Hello!"));

        Function<String, Integer> length = x -> x.length();
        System.out.println("Длина строки: " + length.apply("Hello!"));

        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Квадрат числа: " + square.apply(8));

        Function<List<Integer>, Integer> sumList = a -> a.stream().reduce((x, y) -> x + y).get();
        System.out.println("Сумма элементов списка: " + sumList.apply(numbers));

        Predicate<String> a = x -> x.startsWith("A");
        System.out.println("Слово начинается на А: " + a.test("Apple"));

        Function<List<Integer>, List<Integer>> squareList = l -> l.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Список квадратов: " + squareList.apply(numbers));


    }
}
