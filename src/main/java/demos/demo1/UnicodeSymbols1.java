package demos.demo1;

import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnicodeSymbols1 {
    public static void main(String... args) {
        trueLambda();
        physics();
    }

    private static void trueLambda() {
        List<Integer> ints = List.of(1, 2, 3);

        Consumer<Integer> λ = i -> System.out.println(i);
        ints.forEach(λ);
    }

    private static void physics() {
        double ΔL = 8;
        double L = 2;
        double ε = ΔL / L;

        System.out.println(ε);
    }
}
