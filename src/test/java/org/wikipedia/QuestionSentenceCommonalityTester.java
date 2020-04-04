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
public class QuestionSentenceCommonalityTester {

    public QuestionSentenceCommonalityTester() {
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
        QuestionSentenceCommonality questionSentenceCommonality = QuestionSentenceCommonality
                .generate(SentenceWordsMap.generate(Sentences.create()));
        questionSentenceCommonality.print();
        Assert.assertEquals(5,
                questionSentenceCommonality.getQuestionParaCommonalityMap()
                        .get("Which are the three species of zebras?")
                        .get("There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra").size());
        Assert.assertEquals(2,
                questionSentenceCommonality.getQuestionParaCommonalityMap()
                        .get("Which Zebras are endangered?")
                        .get("Grévy's zebra and the mountain zebra are endangered").size());
        Assert.assertEquals(4,
                questionSentenceCommonality.getQuestionParaCommonalityMap()
                        .get("What is the aim of the Quagga Project?")
                        .get("While plains zebras are much more plentiful, one subspecies, the quagga, became extinct in the late 19th century – though there is currently a plan, called the Quagga Project, that aims to breed zebras that are phenotypically similar to the quagga in a process called breeding back").size());
        Assert.assertEquals(5,
                questionSentenceCommonality.getQuestionParaCommonalityMap()
                        .get("Which subgenus do the plains zebra and the mountain zebra belong to?")
                        .get("There are three species of zebras: the plains zebra, the Grévy's zebra and the mountain zebra").size());
        Assert.assertEquals(3,
                questionSentenceCommonality.getQuestionParaCommonalityMap()
                        .get("Which animals are some of their closest relatives?")
                        .get("Unlike their closest relatives, horses and donkeys, zebras have never been truly domesticated").size());

        questionSentenceCommonality.print();
    }
}
