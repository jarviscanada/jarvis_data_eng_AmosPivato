package ca.jrvs.apps.practice.search;

import org.junit.*;

import java.util.Arrays;
import java.util.Optional;

public class BinarySearchUnitTest {

    @BeforeClass
    public static void classSetUp() throws Exception {
        System.out.println("--@BeforeClass Class is instantiated");
    }

    @AfterClass
    public static void classTearDown() throws Exception {
        System.out.println("--@AfterClass class is no longer being used test is complete");
    }

    private BinarySearch binarySearch;

    @Before
    public void setUp() throws Exception {
        System.out.println("--@Before method will be run and tested with new class instance");
        binarySearch = new BinarySearch();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--@After test was succesfully passed removing object");
    }

    @Test
    public void binarySearchRecursion() {
        System.out.println("Test case: testing recursive binarysearch with integer array");
        Integer[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        int expected1 = 5;
        Assert.assertEquals(Optional.of(expected1), binarySearch.binarySearchRecursion(arr1, 6,0, arr1.length));
        System.out.println("Test case: testing recursive binarysearch with String array");
        String[] arr2 = {"bob", "bruh", "hand", "plane", "jar"};
        Arrays.sort(arr2);
        int expected2 = 1;
        Assert.assertEquals(Optional.of(expected2), binarySearch.binarySearchRecursion(arr2, "bruh", 0, arr2.length));
        System.out.println("Test case: testing recursive binarysearch for element that isn't there");
        Assert.assertEquals(Optional.empty(), binarySearch.binarySearchRecursion(arr2, "hello", 0, arr2.length));
    }

    @Test
    public void binarySearchIteration() {
        System.out.println("Test case: testing iterative binarysearch with integer array");
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expected1 = 5;
        Assert.assertEquals(Optional.of(expected1), binarySearch.binarySearchIteration(arr1, 6));
        System.out.println("Test case: testing iterative binarysearch with String array");
        String[] arr2 = {"bob", "bruh", "hand", "plane", "jar"};
        Arrays.sort(arr2);
        int expected2 = 1;
        Assert.assertEquals(Optional.of(expected2), binarySearch.binarySearchIteration(arr2, "bruh"));
        System.out.println("Test case: testing recursive binarysearch for element that isn't there");
        Assert.assertEquals(Optional.empty(), binarySearch.binarySearchIteration(arr2, "hello"));
    }
}