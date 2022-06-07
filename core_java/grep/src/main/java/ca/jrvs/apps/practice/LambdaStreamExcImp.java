package ca.jrvs.apps.practice;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements LambdaStreamExc{


    @Override
    public Stream<String> createStrStream(String... strings) {
        //... is called varargs and allows for the paramter to be inputed with an uknown amount of values before hand and consolidates them into
        //an array
       return Arrays.stream(strings);
    }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        return this.createStrStream(strings).map(String::toUpperCase);
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return stringStream.filter(s -> !s.matches(pattern));
    }

    @Override
    public IntStream createInStream(int[] arr) {
        return Arrays.stream(arr);
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        //boxed converts intStream to a Stream<integer>
        return intStream.boxed().collect(Collectors.toList());
    }

    @Override
    public IntStream creatIntStream(int start, int end) {
        IntStream intStream = IntStream.range(start, end);
        return intStream;
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return intStream.asDoubleStream().map(x -> Math.sqrt(x));
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        return intStream.filter(num -> num % 2 != 0);
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return (message) -> System.out.println(prefix+message+suffix);
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {
        for (String message : messages) {
            printer.accept(message);
        }
    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {
        String[] oddNums = this.getOdd(intStream)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        this.printMessages(oddNums, printer);
    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        //using flatmap vs using map, perfroms flatning along with mapping and processes
        //the stream of stream's values
        //also using one to manu mappings
        return ints.flatMap(pList -> pList.stream().map(num -> num * num));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses((TestJunit.class));

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}