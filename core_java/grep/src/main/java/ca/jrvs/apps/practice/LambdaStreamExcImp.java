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
        Stream<String> stream = Arrays.stream(strings);
        return stream;
    }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        Stream<String> stream = this.createStrStream(strings)
            .map(String::toUpperCase);
        return stream;
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        stringStream.filter(s -> !s.matches(pattern));
        return stringStream;
    }

    @Override
    public IntStream createInStream(int[] arr) {
        IntStream intStream = Arrays.stream(arr);
        return intStream;
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        List<E> list = stream.collect(Collectors.toList());
        return list;
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        //boxed converts intStream to a Stream<integer>
        List<Integer> list = intStream.boxed().collect(Collectors.toList());
        return list;
    }

    @Override
    public IntStream creatIntStream(int start, int end) {
        IntStream intStream = IntStream.range(start, end);
        return intStream;
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        DoubleStream doubleStream = intStream
                .asDoubleStream()
                .map(x -> Math.sqrt(x));
        return doubleStream;
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
        intStream.filter(num -> num % 2 != 0);
        return intStream;
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        Consumer<String> printer = (message) -> System.out.println(prefix+message+suffix);
        return printer;
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
        Stream<Integer> flatints= ints.flatMap(pList -> pList.stream().map(num -> num * num));
        return flatints;
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses((TestJunit.class));

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}