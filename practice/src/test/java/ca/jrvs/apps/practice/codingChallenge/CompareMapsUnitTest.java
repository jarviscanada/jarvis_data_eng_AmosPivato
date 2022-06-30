package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.map.HashJMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CompareMapsUnitTest {

    private CompareMaps compareMaps;

    @Before
    public void setUp() throws Exception {
        System.out.println("test case set up");
        compareMaps = new CompareMaps();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case closing");
    }

    @Test
    public void compareMaps1() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);
        map1.put("e", 5);

        Map<String, Integer> expected1 = new HashMap<>();
        expected1.put("a", 1);
        expected1.put("b", 2);
        expected1.put("c", 3);
        expected1.put("d", 4);
        expected1.put("e", 5);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.put("b", 1);
        map2.put("c", 1);
        map2.put("d", 1);
        map2.put("e", 1);

        Map<String, Integer> expected2 = new HashMap<>();
        expected2.put("a", 1);
        expected2.put("b", 2);
        expected2.put("c", 3);
        expected2.put("d", 4);
        expected2.put("e", 5);

        assertTrue(compareMaps.compareMaps1(map1, expected1));
        assertFalse(compareMaps.compareMaps1(map2, expected2));
    }

    @Test
    public void compareMap2() {
        HashJMap<String, Integer> map1 = new HashJMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);
        map1.put("e", 5);

        HashJMap<String, Integer> expected1 = new HashJMap<>();
        expected1.put("a", 1);
        expected1.put("b", 2);
        expected1.put("c", 3);
        expected1.put("d", 4);
        expected1.put("e", 5);

        HashJMap<String, Integer> map2 = new HashJMap<>();
        map2.put("a", 1);
        map2.put("b", 1);
        map2.put("c", 1);
        map2.put("d", 1);
        map2.put("e", 1);

        HashJMap<String, Integer> expected2 = new HashJMap<>();
        expected2.put("a", 1);
        expected2.put("b", 2);
        expected2.put("c", 3);
        expected2.put("d", 4);
        expected2.put("e", 5);

        assertTrue(compareMaps.compareMap2(map1, expected1));
        assertFalse(compareMaps.compareMap2(map2, expected2));
    }
}