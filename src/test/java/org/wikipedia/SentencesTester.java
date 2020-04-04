package org.wikipedia;

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
public class SentencesTester {

    public SentencesTester() {
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
        Sentences sentencesCreator = Sentences.create();
        Assert.assertEquals(sentencesCreator.getParaSentences().size(), 13);
        Assert.assertEquals(sentencesCreator.getQuestions().size(), 5);
        Assert.assertEquals(sentencesCreator.getAnswers().size(), 5);
    }
}
