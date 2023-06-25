package java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import util.DataUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 01. Method reference for Static method
        // Example 1
        DataUtil.nums.stream()
                .map(num -> Math.sqrt(num))
                .forEach(newNum -> System.out.println(newNum));

        DataUtil.nums.stream()
                .map(Math::sqrt)
                .forEach(System.out::println);

        // Example 2
        Function<String, String> message = WelcomeGreeting::greet;
        System.out.println(message.apply("from Teja"));

        // 02. Method reference for instance method for particular object
        List<Bike> bikes = new ArrayList<Bike>(Arrays.asList(new Bike("Hero", 25), new Bike("Super", 28),
                new Bike("Bajaj", 20), new Bike("Tesla", 26), new Bike("HRX", 30)));
        BikeComparator bikeComparator = new BikeComparator();
        System.out.println(bikes.stream()
                .sorted((o1, o2) -> bikeComparator.compare(o1, o2))
                .collect(Collectors.toList()));

        System.out.println(bikes.stream()
                .sorted(bikeComparator::compare)
                .collect(Collectors.toList()));

        // Example 2
        Sum s = new Sum();
        BiFunction<Integer, Integer, Integer> add = s::sumOfNumbers;
        System.out.println(add.apply(10, 20));


        // 03. Reference to an Instance Method of an Arbitrary Object of a Particular Type
        // Example 1
        bikes.forEach(Bike::printDetails);

        // Example 2
        String value = "hello";
        Stream.of(value).map(v -> v.toUpperCase()).forEach(v -> System.out.println(v));
        Stream.of(value).map(String::toUpperCase).forEach(System.out::println);

        // 04. Reference to Constructor
        // Example 1
        BiFunction<String, Integer, Bike> fnOld = (brand, frameSize) -> new Bike(brand, frameSize);
        BiFunction<String, Integer, Bike> fn = Bike::new;
        System.out.println(fn.apply("Hero", 25));

        // Example 2
        List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");

        System.out.println(bikeBrands.stream()
                .map((brand) -> new Bike(brand))
                .collect(Collectors.toList()));

        System.out.println(bikeBrands.stream()
                .map(Bike::new)
                .collect(Collectors.toList()));
        System.out.println("---------End----------");
    }
}

class WelcomeGreeting {
    public static String greet(String msg) {
        return "Welcome! " + msg;
    }
}

@Data
@AllArgsConstructor
class Bike {
    String brand;
    Integer frameSize;

    public Bike(String brand){
        this.brand = brand;
    }
    public void printDetails() {
        System.out.println(brand + " " + frameSize);
    }
}

class BikeComparator implements Comparator<Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {
        return o1.getFrameSize().compareTo(o2.getFrameSize());
    }
}

class Sum {
    public int sumOfNumbers(int a, int b) {
        return a + b;
    }
 
}
