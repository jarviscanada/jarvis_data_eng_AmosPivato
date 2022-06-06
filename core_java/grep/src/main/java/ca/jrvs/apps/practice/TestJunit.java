package ca.jrvs.apps.practice;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
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
        List<String> output1 = lsei.filter(sStream, "a").collect(Collectors.toList());
        List<String> expected1 = Arrays.asList("UNTITLED", "BOB", "REVIEW");
        assertEquals(expected1, output1);

        //createintstream test
        int[] ints = {1,2,3,4,5,6,7,8,9};
        IntStream intStream = lsei.createInStream(ints);
        List<Integer> output2 = intStream.boxed().collect(Collectors.toList());
        List<Integer> expected2 = Arrays.asList(1,2,3,4,5,6,7,8,9);
        assertEquals(expected2, output2);

        //toList of any stream type test
        List<String> output3 = lsei.toList(sStream);
        assertEquals(expected0, output3);

        //toList of instream type test
        List<Integer> output4 = lsei.toList(intStream);
        assertEquals(expected2, output4);

        //create intstream from range test
        List<Integer> output5 = lsei.creatIntStream(1,9).boxed().collect(Collectors.toList());
        assertEquals(expected2, output4);

        //test for squareroot of stream
        int[] square = {1,4,9};
        IntStream intsS = lsei.createInStream(square);
        List<Double> output6 = lsei.squareRootIntStream(intsS).boxed().collect(Collectors.toList());
        List<Double> expected3 = Arrays.asList(1.0,2.0,3.0);
        assertEquals(expected3, output6);

        //get odd test
        List<Integer> output7 = lsei.getOdd(intStream).boxed().collect(Collectors.toList());
        List<Integer> epected4 = Arrays.asList(1,3,5,7,9);
        assertEquals(epected4, output7);

        //tests for getlambdaprinter


        //test flatnested ints

    }

}
