
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        MathDoubleOperator functionalInterface = () ->{
            OptionalDouble average = eval(list, n -> n % 2 == 0).stream().mapToInt(Integer::intValue).average();
            return average.getAsDouble();
        };
        System.out.println(functionalInterface.average());
    }

    public static List<Integer> eval(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(integer ->  predicate.test(integer)).collect(Collectors.toList());
    }
}
