package java8;

import util.DataUtil;

import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaExpressionDemo {

    public static void main(String[] args) {
//        List<String> names = new ArrayList<String>(Arrays.asList("Teja", "Baby", "Sudhu", "Bala"));
//        // Immutable Map
//        Map<Integer, String> namesMap = Map.of(1, "Teja M", 2, "Baby M", 3, "Sudhu M", 4, "Bala M");

        // Example 1: Using Consumer, forEach > for Iteration
        DataUtil.names.forEach(name -> System.out.println(name));

        System.out.println("---------------------");

        // Example 2: Assigning functionality to Consumer reference variable
        Consumer cmr = (var name) -> {
            name = "Hello " + name;
            System.out.println(name + "!!");
        };
        // forEach iteration
        DataUtil.names.forEach(cmr);

        System.out.println("---------------------");

        // Example 3: Using "Shape" created interface with method having 2 parameters
        Shape circle = (int a, int b) -> {
            System.out.println("Circle drawn using value " + (a + b));
        };
        // Passing functionality as method argument
        drawShape(circle);

        System.out.println("---------------------");

        // Example 4: Filter data from collection libraries
        Map<Integer, String> filteredNames = DataUtil.namesMap.entrySet().stream()
                .filter(e -> e.getValue().contains("a"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filteredNames);

        // Example 5:
        Consumer<String> method = (s) -> {
            System.out.println("Name is " + s);
        };
        DataUtil.names.forEach(method);

    }

    // Draw shape method
    public static void drawShape(Shape shape) {
        shape.draw(55, 2);
    }
}
