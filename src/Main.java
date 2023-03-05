import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("frog", 1));
        animals.add(new Animal("crocodile", 2));
        animals.add(new Animal("lion", 3));
        animals.add(new Animal("whale", 4));
        animals.add(new Animal("dolphin", 5));
        animals.add(new Animal("rhino", 11));
        animals.add(new Animal("tiger", 7));
        animals.add(new Animal("elephant", 20));
        animals.add(new Animal("parrot", 30));
        animals.add(new Animal("horse", 10));

        Optional<Animal> isLion = animals.stream()
                .filter(animal -> animal.getName().equals("lion"))
                .findAny();

        if (isLion.isPresent()) {
            Animal lion = isLion.get();
            System.out.println("Возраст льва: " + lion.getAge());
        } else {
            throw new IllegalArgumentException();
        }

        long animalsOverFour = animals.stream()
                .filter(animal -> animal.getAge() > 4)
                .count();
        System.out.println("Всего животных старше четырёх лет: " + animalsOverFour);

        animals.stream()
                .sorted(Comparator.comparingInt(animal -> animal.getAge()))
                .forEach(animal -> System.out.println(animal.getName() + ", возраст: " + animal.getAge()));

        Map<String, Animal> animalMap = animals.stream()
                .collect(Collectors.toMap((animal -> animal.getName()), animal -> animal));
        System.out.println(animalMap);

        Optional<String> animalStr = animals.stream()
                .map(animal -> animal.getName())
                .reduce((prev, next) -> prev + ", " + next);

        if (animalStr.isPresent()) {
            String animalString = animalStr.get();
            System.out.println(animalString);
        }
    }
}
