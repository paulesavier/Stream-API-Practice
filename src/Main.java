import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("frog", 1));
        animals.add(new Animal("crocodile", 2));
        animals.add(new Animal("lion", 3));
        animals.add(new Animal("whale", 4));
        animals.add(new Animal("dolphin", 5));
        animals.add(new Animal("rhino", 6));
        animals.add(new Animal("tiger", 7));
        animals.add(new Animal("elephant", 8));
        animals.add(new Animal("parrot", 9));
        animals.add(new Animal("horse", 10));

        Stream<Animal> stream = animals.stream();
        animals.stream()
                .filter(animal -> animal.getAge() > 5)
                .forEach(animal -> System.out.println(animal.getName()));
        }
}
