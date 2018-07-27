package functional;

import java.util.function.Function;

public class FooSample {

    enum Type { SOME }
    public static void main(String[] args) {
        Type t = Type.SOME;
        // This could come from somewhere, by enum maybe?
        Function<String, String> doStringSomething =
                new FooFactory<String>().curryDoSomething.apply(String.class);

        // When you use it, you're using the class from above.
        String s = doStringSomething.apply("input");
    }
}

class Foo {
    public static <T> T doSomething(Class<T> clazz, String input) {
        return clazz.cast(new Object());
    }
}

class FooFactory<T> {
    public Function<Class<T>, Function<String, T>> curryDoSomething = clazz -> input -> Foo.doSomething(clazz, input);
}