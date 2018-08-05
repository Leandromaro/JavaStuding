import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Collection<Person> people = new ArrayList<>();

    public static void  main(String[]args){
        Person personOne = new Main().new Person("Leandro", "Maro", Sex.male);
        Person personTwo = new Main().new Person("Leandro", "Maro", Sex.male);
        Person personThree = new Main().new Person("Eugenia", "Nuñez", Sex.female);

        people.add(personOne);
        people.add(personTwo);
        people.add(personThree);

        Set<String> set = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.printf("TreeSet:\n");
        set.stream().forEach(System.out::println);
        System.out.printf("HashSet:\n");
        HashSet<String> hashSet = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.stream().forEach(System.out::println);
        System.out.printf("LinkedHashSet:\n");
        Set<String> LinkedHashSet = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet.stream().forEach(System.out::println);

    }

    class Person{

        private String name;
        private String lastName;
        private Sex sex;

        public Person(String name, String lastName, Sex sex) {
            this.name = name;
            this.lastName = lastName;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Sex getSex() {
            return sex;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }
    }

    enum Sex{
        male, female;
    }
}
