import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Leandro", Person.Sex.MALE, LocalDate.of(1985, Month.AUGUST, 3)));

        Person.printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }
}
