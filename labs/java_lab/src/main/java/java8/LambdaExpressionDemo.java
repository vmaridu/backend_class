package java8;

public class LambdaExpreesionDemo {

    static Shape circle = (int a, int b) ->  a + b;

    public static void main(String[] args) {
        System.out.println("Value is " + circle.draw(55,2));
    }
}
