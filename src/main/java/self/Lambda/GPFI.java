package self.Lambda;

import java.util.function.*;

public class GPFI {
    public static void main(String[] args) {
        Supplier<String> supplier=()->"shiv";
        System.out.println(supplier.get());

        Consumer <Integer>consumer=(a)-> System.out.println(a);
        consumer.accept(10);

        BiConsumer <Integer,Integer>biConsumer=(a, b)-> System.out.println(a+b);
        biConsumer.accept(10,20);

        Predicate<Integer> predicate=(no)->no>10;
        System.out.println(predicate.test(20));

        BiPredicate<Integer,Integer>biPredicate=(no,no1)->no>no1;
        System.out.println(biPredicate.test(10,20));

        Function<String,Integer>function=(a)->a.length();
        System.out.println(function.apply("10"));

        BiFunction<String,String,Integer>biFunction=(a,b)->a.length()+b.length();
        System.out.println(biFunction.apply("Shiv","Kant"));

    }
}
