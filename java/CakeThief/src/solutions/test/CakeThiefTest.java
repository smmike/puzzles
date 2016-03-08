package solutions.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import solutions.CakeThief;
import solutions.CakeType;

import java.util.HashMap;


/** 
* CakeThief Tester. 
* 
* @author Mikhail Smirnov
*/ 
public class CakeThiefTest {

    CakeThief cakeThief;

    @Before
    public void setUp() throws Exception {
        cakeThief = new CakeThief();
    }


    @Test
    public void testMaxDuffelBagValue1() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 120),
                new CakeType(4, 90),
                new CakeType(2, 15),
                new CakeType(2, 5),
                new CakeType(2, 4),
                new CakeType(2, 3),
                new CakeType(2, 2),
                new CakeType(1, 1)
        };
        int capacity = 21;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(451, maxDuffelBagValue);

    }

    @Test
    public void testMaxDuffelBagValue2() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 0),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };
        int capacity = 20;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(555, maxDuffelBagValue);

    }

    @Test
    public void testMaxDuffelBagValue3() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(0, 1),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };
        int capacity = 20;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(Integer.MAX_VALUE, maxDuffelBagValue);
    }


    @Test
    public void testMaxDuffelBagValue4() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(0, 0),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(555, maxDuffelBagValue);
    }

    @Test
    public void testMaxDuffelBagValue5() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(0, 0),
                new CakeType(21, 999999),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };
        int capacity = 20;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(555, maxDuffelBagValue);
    }


    @Test
    public void testMaxDuffelBagValue6() {
        CakeType[] cakeTypes = new CakeType[]{
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };
        int capacity = 0;
        int maxDuffelBagValue = cakeThief.maxDuffelBagValue(cakeTypes, capacity);
        cakeThief.printLastSolution();
        Assert.assertEquals(0, maxDuffelBagValue);

    }
} 
