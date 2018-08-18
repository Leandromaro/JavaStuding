import java.time.LocalDate;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name, Sex gender, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

             public int getAge() {
        return 1;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void printPerson() {
        System.out.println(this);
    }

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}