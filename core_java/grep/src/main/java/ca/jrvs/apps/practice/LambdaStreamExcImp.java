package ca.jrvs.apps.practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements LambdaStreamExc{


    @Override
    public Stream<String> createStrStream(String... string) {
        return null;
    }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        return null;
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {
        return null;
    }

    @Override
    public IntStream createInStream(int[] arr) {
        return null;
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {
        return null;
    }

    @Override
    public List<Integer> toList(IntStream inStream) {
        return null;
    }

    @Override
    public IntStream creatIntStream(int start, int end) {
        return null;
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
        return null;
    }

    @Override
    public IntStream gerOdd(IntStream intStream) {
        return null;
    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
        return null;
    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {

    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {

    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        return null;
    }
}