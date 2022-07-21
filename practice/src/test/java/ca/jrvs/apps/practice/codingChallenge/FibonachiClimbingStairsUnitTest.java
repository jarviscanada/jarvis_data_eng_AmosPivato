package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.sorting.MergeSort;
import ca.jrvs.apps.practice.sorting.QuickSort;
import org.junit.*;

import static org.junit.Assert.*;

public class FibonachiClimbingStairsUnitTest {

    @BeforeClass
    public static void classSetUp() throws Exception {
        System.out.println("--@BeforeClass Class is instantiated");
    }

    @AfterClass
    public static void classTearDown() throws Exception {
        System.out.println("--@AfterClass class is no longer being used test is complete");
    }

    private FibonachiClimbingStairs fcs;

    @Before
    public void setUp() throws Exception {
        System.out.println("--@Before method will be run and tested with new class instance");
        fcs = new FibonachiClimbingStairs();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--@After test attempt removing object");
    }

    @Test
    public void fcsRecursive() {
        System.out.println("testing Dynamic fibonacci");
        assertEquals(0, fcs.fcsRecursive(0));
        assertEquals(1, fcs.fcsRecursive(2));
        assertEquals(55, fcs.fcsRecursive(10));
        System.out.println("test passed");
    }

    @Test
    public void fcsDynamic() {
        System.out.println("testing recursive fibonacci");
        assertEquals(0, fcs.fcsDynamic(0));
        assertEquals(1, fcs.fcsDynamic(2));
        assertEquals(55, fcs.fcsDynamic(10));
        System.out.println("test passed");
    }
}