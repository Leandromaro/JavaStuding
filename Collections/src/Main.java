import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static Collection<Person> people = new ArrayList<>();

    public static void  main(String[]args){
        Person personOne = new Main().new Person("Leandro", "Maro", Gender.male);
        Person personTwo = new Main().new Person("Leandro", "Maro", Gender.male);
        Person personThree = new Main().new Person("Eugenia", "Nuñez", Gender.female);

        people.add(personOne);
        people.add(personTwo);
        people.add(personThree);
        // Stores its elements in a hash table, is the best-performing implementation;
        // however it makes no guarantees concerning the order of iteration
        System.out.printf("HashSet:\n");
        Set<String> hashSet = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.stream().forEach(System.out::println);
        System.out.printf("\n");
        // Stores its elements in a red-black tree, orders its elements based on their values;
        // it is substantially slower than HashSet
        Set<String> set = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.printf("TreeSet:\n");
        set.stream().forEach(System.out::println);
        System.out.printf("\n");
        System.out.printf("LinkedHashSet:\n");
        // It's implemented as a hash table with a linked list running through it,
        // orders its elements based on the order in which they were inserted into the set (insertion-order)
        Set<String> LinkedHashSet = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet.stream().forEach(System.out::println);
    }

    class Person{

        private String name;
        private String lastName;
        private Gender gender;

        public Person(String name, String lastName, Gender gender) {
            this.name = name;
            this.lastName = lastName;
            this.gender = gender;
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

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }

    enum Gender {
        male, female;
    }
}
