package ca.jrvs.apps.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;

public class TestJunit extends LambdaStreamExcImp{
    @Test

    public void testAdd() {
        LambdaStreamExcImp lsei = new LambdaStreamExcImp();

        //test for createStreStream and toUpperCase if this test succeed then they both are returning streams
        //and accomplishing their objectives
        Stream<String> sStream = lsei.createStrStream("coral", "untitled", "Bob", "review", "coach");
        List<String> output0 = sStream.collect(Collectors.toList());
        List<String> expected0 = Arrays.asList("coral", "untitled", "Bob", "review", "coach");
        assertEquals(output0, expected0);

        List<String> output = lsei.toUpperCase("coral", "untitled", "Bob", "review", "coach").collect(Collectors.toList());
        List<String> expected = Arrays.asList("CORAL", "UNTITLED", "BOB", "REVIEW", "COACH");
        assertEquals(expected, output);

        //test for filter
        Stream<String> sStream1 = lsei.createStrStream("coral", "untitled", "Bob", "review", "coach");
        List<String> output1 = lsei.filter(sStream1, ".*a.*").collect(Collectors.toList());
        List<String> expected1 = Arrays.asList("untitled", "Bob", "review");
        assertEquals(expected1, output1);

        //createintstream test
        int[] ints = {1,2,3,4,5,6,7,8,9};
        IntStream intStream = lsei.createInStream(ints);
        List<Integer> output2 = intStream.boxed().collect(Collectors.toList());
        List<Integer> expected2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        assertEquals(expected2, output2);

        //toList of any stream type test
        Stream<String> sStream2 = lsei.createStrStream("coral", "untitled", "Bob", "review", "coach");
        List<String> output3 = lsei.toList(sStream2);
        assertEquals(expected0, output3);

        //toList of instream type test
        IntStream intStream1 = lsei.createInStream(ints);
        List<Integer> output4 = lsei.toList(intStream1);
        assertEquals(expected2, output4);

        //create intstream from range test
        List<Integer> output5 = lsei.creatIntStream(1,10).boxed().collect(Collectors.toList());
        assertEquals(expected2, output5);

        //test for squareroot of stream
        int[] square = {1,4,9};
        IntStream intsS = lsei.createInStream(square);
        List<Double> output6 = lsei.squareRootIntStream(intsS).boxed().collect(Collectors.toList());
        List<Double> expected3 = Arrays.asList(1.0,2.0,3.0);
        assertEquals(expected3, output6);

        //get odd test
        IntStream intStream2 = lsei.createInStream(ints);
        List<Integer> output7 = lsei.getOdd(intStream2).boxed().collect(Collectors.toList());
        List<Integer> expected4 = Arrays.asList(1,3,5,7,9);
        assertEquals(expected4, output7);

        //tests for getlambdaprinter
        Consumer<String> printer = lsei.getLambdaPrinter("the message:", ". end!");
        printer.accept("helllo who is this");

        //print messages
        String[] messages = {"roger roger", "this is the squadron reporting in", "we have target acquired"};
        lsei.printMessages(messages, printer);

        //tests for print odd
        lsei.printOdd(lsei.creatIntStream(0,10), printer);

        //test flatnested ints
        List<List<Integer>> nest = new ArrayList<>();
        List<Integer> child1 = Arrays.asList(1,2,3);
        List<Integer> child2 = Arrays.asList(4,5,6);
        List<Integer> child3 = Arrays.asList(7,8,9);
        nest.add(child1);
        nest.add(child2);
        nest.add(child3);
        Stream<List<Integer>> nested = nest.stream();
        List<Integer> output8 = lsei.flatNestedInt(nested).collect(Collectors.toList());
        List<Integer> expected5 = Arrays.asList(1,4,9,16, 25, 36, 49, 64, 81);
        assertEquals(expected5, output8);
    }

}
