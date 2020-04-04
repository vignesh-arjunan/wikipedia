package org.wikipedia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.toList;
import org.wikipedia.util.SetIntersector;

/**
 *
 * @author VARJUNAN
 */
public class QuestionSentenceCommonality {

    private final Map<String, Map<String, Set<String>>> questionParaCommonalityMap = new HashMap<>();

    private QuestionSentenceCommonality(SentenceWordsMap sentenceWordsMaps) {
        sentenceWordsMaps.getQuestionsMap().keySet().forEach(question -> {
            Map<String, Set<String>> map = new HashMap<>();
            sentenceWordsMaps.getParaMap().keySet().forEach(para -> {
                map.put(para, SetIntersector.intersect(sentenceWordsMaps.getQuestionsMap().get(question), sentenceWordsMaps.getParaMap().get(para)));
            });
            questionParaCommonalityMap.put(question, map);
        });
    }

    public static QuestionSentenceCommonality generate(SentenceWordsMap sentenceWordsMapsGenerator) {
        return new QuestionSentenceCommonality(sentenceWordsMapsGenerator);
    }

    public Map<String, Map<String, Set<String>>> getQuestionParaCommonalityMap() {
        return questionParaCommonalityMap;
    }

    public void filterHighestCommons() {
        questionParaCommonalityMap.keySet().forEach(question -> {
            Map<String, Set<String>> paraWordsMap = questionParaCommonalityMap.get(question);
            int max_size = paraWordsMap.keySet().stream().map(key -> paraWordsMap.get(key).size()).max(Integer::compare).get();
            List<String> maxKeys = paraWordsMap.keySet().stream().filter(key -> paraWordsMap.get(key).size() == max_size).collect(toList());
            Map<String, Set<String>> filteredparaWordsMap = new HashMap<>();
            paraWordsMap.keySet().forEach(key -> {
                if (maxKeys.contains(key)) {
                    filteredparaWordsMap.put(key, paraWordsMap.get(key));
                }
            });
            questionParaCommonalityMap.put(question, filteredparaWordsMap);
        });
    }

    public void print() {
        questionParaCommonalityMap.keySet().forEach(question -> {
            System.out.println("question -> " + question);
            Map<String, Set<String>> map = questionParaCommonalityMap.get(question);
            map.keySet().forEach(para -> {
                System.out.println("    para -> " + para);
                System.out.println("        commonality -> " + map.get(para).size());
                map.get(para).forEach(word -> System.out.print("        " + word + " "));
                System.out.println();
            });
            System.out.println("---------------------------------");
        });
    }
}
