import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Collection<Person> people = new ArrayList<>();

    public static void  main(String[]args){
        Person personOne = new Main().new Person("Leandro", "Maro", Gender.MALE, 33, City.RESISTENCIA);
        Person personTwo = new Main().new Person("Leandro", "Maro", Gender.MALE, 33, City.RESISTENCIA);
        Person personThree = new Main().new Person("Eugenia", "Nuñez", Gender.FEMALE, 30, City.CORRIENTES);

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

        // Maps
        // Collecting maps from a List and grouping them into maps
        System.out.printf("\n");
        System.out.printf("Maps\n");
        System.out.printf("\n");
        Map<Integer, List<Person>> peopleMap = people.stream().collect(Collectors.groupingBy(Person::getAge));
        Map<Boolean, List<Person>> peopleMapByAge = people.stream().collect(Collectors.partitioningBy(p -> p.age > 30));
        Map<City, Integer> peopleByCitySumAge = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.summingInt(p -> p.age)));

        System.out.println(peopleMap.entrySet() + "\n");
        System.out.println(peopleMapByAge.values()+ "\n");
        System.out.println(peopleByCitySumAge.values()+ "\n");

        // PriorityQueue with custom comparator
        System.out.println("Priority Queue \n");
        Queue<Person> list = new PriorityQueue<>(Comparator.comparingInt(Person::getAge));
        list.add(new Main().new Person("Leandro", "Maro", Gender.MALE, 33, City.RESISTENCIA));
        list.add(new Main().new Person("Leandro", "Maro", Gender.MALE, 33, City.RESISTENCIA));
        list.add(new Main().new Person("Eugenia", "Nuñez", Gender.FEMALE, 30, City.CORRIENTES));
        list.forEach(System.out::println);
    }

    class Person{

        private String name;
        private String lastName;
        private Gender gender;
        private int age;
        private City city;

        public Person(String name, String lastName, Gender gender, int age, City city) {
            this.name = name;
            this.lastName = lastName;
            this.gender = gender;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public String getLastName() {
            return lastName;
        }

        public Gender getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        public City getCity() {
            return city;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCity(City city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    ", city=" + city +
                    '}';
        }
    }

    enum City{
        RESISTENCIA, CORRIENTES;
    }

    enum Gender {
        MALE, FEMALE;
    }
}
