package org.wikipedia;

import org.wikipedia.util.Sentence2UniqueWords;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import static java.util.stream.Collectors.toMap;

/**
 *
 * @author varjunan
 */
public class SentenceWordsMap {

    private final Map<String, Set<String>> paraMap;
    private final Map<String, Set<String>> questionsMap;
    private final Map<String, Set<String>> answersMap;
    private final Sentences sentences;

    private SentenceWordsMap(Sentences sentences) {
        this.sentences = sentences;
        paraMap = sentences.getParaSentences().stream().collect(toMap(Function.identity(), Sentence2UniqueWords::convert));
        questionsMap = sentences.getQuestions().stream().collect(toMap(Function.identity(), Sentence2UniqueWords::convert));
        answersMap = sentences.getAnswers().stream().collect(toMap(Function.identity(), Sentence2UniqueWords::convert));
    }

    public static SentenceWordsMap generate(Sentences sentences) {
        return new SentenceWordsMap(sentences);
    }

    public Map<String, Set<String>> getParaMap() {
        return paraMap;
    }

    public Map<String, Set<String>> getQuestionsMap() {
        return questionsMap;
    }

    public Map<String, Set<String>> getAnswersMap() {
        return answersMap;
    }

    public Sentences getSentences() {
        return sentences;
    }

}
