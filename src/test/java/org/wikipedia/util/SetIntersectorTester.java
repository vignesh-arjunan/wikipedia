package org.wikipedia.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author varjunan
 */
public class SetIntersectorTester {

    public SetIntersectorTester() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void generalTest() {
        Set set1 = new HashSet(Arrays.asList(1, 2));
        Set set2 = new HashSet(Arrays.asList(2, 3));
        Set intersection = SetIntersector.intersect(set1, set2);
        Assert.assertEquals(1, intersection.size());
        set1.forEach(System.out::println);
        System.out.println("-------");
        set2.forEach(System.out::println);
        System.out.println("-------");
        intersection.forEach(System.out::println);
        System.out.println("-------");
    }
}
