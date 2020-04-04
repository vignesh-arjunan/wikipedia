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
public class SentenceWordsMapsTester {

    public SentenceWordsMapsTester() {
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
    public void hello() {
        SentenceWordsMap sentenceWordsMap = SentenceWordsMap.generate(Sentences.create());
        //.getParaMap().get("Zebras are several species of African equids (horse family) united by their distinctive black and white stripes")
        //        .forEach(System.out::println);
        int size = sentenceWordsMap.getParaMap().get("Zebras are several species of African equids (horse family) united by their distinctive black and white stripes").size();
        Assert.assertEquals(17, size);
        //sentenceWordsMap.getQuestionsMap().get("Which Zebras are endangered?")
        //        .forEach(System.out::println);
        size = sentenceWordsMap.getQuestionsMap().get("Which Zebras are endangered?").size();
        Assert.assertEquals(4, size);
        //sentenceWordsMap.getAnswersMap().get("subgenus Hippotigris")
        //        .forEach(System.out::println);
        size = sentenceWordsMap.getAnswersMap().get("subgenus Hippotigris").size();
        Assert.assertEquals(2, size);
    }
}
