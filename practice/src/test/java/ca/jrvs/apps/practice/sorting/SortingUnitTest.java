package ca.jrvs.apps.practice.sorting;

import ca.jrvs.apps.practice.search.BinarySearch;
import org.junit.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import static org.junit.Assert.*;

public class SortingUnitTest {


    @BeforeClass
    public static void classSetUp() throws Exception {
        System.out.println("--@BeforeClass Class is instantiated");
    }

    @AfterClass
    public static void classTearDown() throws Exception {
        System.out.println("--@AfterClass class is no longer being used test is complete");
    }

    private MergeSort mergeSort;
    private QuickSort quickSort;

    @Before
    public void setUp() throws Exception {
        System.out.println("--@Before method will be run and tested with new class instance");
        mergeSort = new MergeSort();
        quickSort = new QuickSort();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--@After test was succesfully passed removing object");
    }

    @Test
    public void Sort() {
        int[] arr1 = {5,8,7,3,1,68,32,2,7,9,0,7,4};
        int[] arr2 = {5,8,7,3,1,68,32,2,7,9,0,7,4};
        int[] small = {4};
        int[] expected = {0,1,2,3,4,5,7,7,7,8,9,32,68};
        System.out.println("testing quicksort, array that is too small");
        quickSort.quickSort(small, 0, small.length-1);
        assertArrayEquals(small, small);
        System.out.println("testing quicksort, unsorted array");
        quickSort.quickSort(arr1, 0, arr1.length-1);
        assertArrayEquals(expected, arr1);
        System.out.println("testing mergesort, array that is too small");
        mergeSort.mergeSort(small);
        assertArrayEquals(small, small);
        System.out.println("testing mergesort, unsorted array");
        mergeSort.mergeSort(arr2);
        assertArrayEquals(expected, arr2);
    }

}