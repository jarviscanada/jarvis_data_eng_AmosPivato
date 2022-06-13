package ca.jrvs.practice.codingChallenge;

import org.junit.*;

import static org.junit.Assert.*;

public class OddEvenUnitTest {

    @BeforeClass
    public static void classSetUp() throws Exception {
        System.out.println("--@BeforeClass static method runs once before class is isntantiated");
    }

    @AfterClass
    public static void classTearDown() throws Exception {
        System.out.println("--@AfterClass static method runs once");
    }

    private OddEven oddEven;

    @Before
    public void setUp() throws Exception {
        System.out.println("--@Before method runs before each @Test method");
        oddEven = new OddEven();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("--@After method runs after each @Test method");
    }

    @Test
    public void oddEvenMod() {
        System.out.println("Test case: test oddEvenMod method from the test class");
        String expected = "odd";
        Assert.assertEquals(expected, oddEven.oddEvenMod(3));
        expected = "even";
        Assert.assertEquals(expected, oddEven.oddEvenMod(4));
    }

    @Test
    public void oddEvenBit() {
        System.out.println("Test case: test oddEvenBit method from the test class");
        String expected = "odd";
        Assert.assertEquals(expected, oddEven.oddEvenBit(3));
        expected = "even";
        Assert.assertEquals(expected, oddEven.oddEvenBit(4));
    }
}