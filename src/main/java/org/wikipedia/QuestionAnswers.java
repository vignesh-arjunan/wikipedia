package org.wikipedia;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author varjunan
 */
public class QuestionAnswers {

    private final QuestionSentenceCommonality questionSentenceCommonality;
    private final SentenceWordsMap sentenceWordsMaps;
    private final Map<String, String> questionAnswerMap = new HashMap<>();

    private QuestionAnswers(QuestionSentenceCommonality questionSentenceCommonality, SentenceWordsMap sentenceWordsMaps) {
        this.questionSentenceCommonality = questionSentenceCommonality;
        this.sentenceWordsMaps = sentenceWordsMaps;
    }

    public static QuestionAnswers create(QuestionSentenceCommonality questionSentenceCommonality, SentenceWordsMap sentenceWordsMaps) {
        return new QuestionAnswers(questionSentenceCommonality, sentenceWordsMaps);
    }

    public Map<String, String> getQuestionAnswerMap() {
        return questionAnswerMap;
    }

    public void computeAnswers() {
        questionSentenceCommonality.filterHighestCommons();

        Map<String, Map<String, Set<String>>> questionParaCommonalityMap = questionSentenceCommonality.getQuestionParaCommonalityMap();
        questionParaCommonalityMap.keySet().forEach(question -> {
            Map<String, Set<String>> paraWordsMap = questionParaCommonalityMap.get(question);
            paraWordsMap.keySet().forEach(paraSentence -> {
                sentenceWordsMaps.getSentences().getAnswers().forEach(answer -> {
                    if (paraSentence.contains(answer) && !questionAnswerMap.containsKey(question)) {
                        questionAnswerMap.put(question, answer);
                    }
                });
            });
        });
    }
}
