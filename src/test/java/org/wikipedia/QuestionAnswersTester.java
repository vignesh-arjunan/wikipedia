package org.wikipedia;

import java.util.Map;
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
public class QuestionAnswersTester {

    public QuestionAnswersTester() {
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
        QuestionAnswers questionAnswers = QuestionAnswers.create(QuestionSentenceCommonality
                .generate(SentenceWordsMap.generate(Sentences.create())), SentenceWordsMap.generate(Sentences.create()));

        questionAnswers.computeAnswers();
        // printing Q and A
        questionAnswers.getQuestionAnswerMap().keySet().forEach(question -> {
            System.out.println(question + "--->" + questionAnswers.getQuestionAnswerMap().get(question));
        });

        Map<String, String> questionAnswerMap = questionAnswers.getQuestionAnswerMap();
        //asserting answers for the questions
        Assert.assertEquals("the plains zebra, the Grévy's zebra and the mountain zebra", questionAnswerMap.get("Which are the three species of zebras?"));
        Assert.assertEquals("Grévy's zebra and the mountain zebra", questionAnswerMap.get("Which Zebras are endangered?"));
        Assert.assertEquals("aims to breed zebras that are phenotypically similar to the quagga", questionAnswerMap.get("What is the aim of the Quagga Project?"));
        Assert.assertEquals("subgenus Hippotigris", questionAnswerMap.get("Which subgenus do the plains zebra and the mountain zebra belong to?"));
        Assert.assertEquals("horses and donkeys", questionAnswerMap.get("Which animals are some of their closest relatives?"));
    }
}
