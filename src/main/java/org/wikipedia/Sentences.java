package org.wikipedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static org.wikipedia.Input.LINE1;
import static org.wikipedia.Input.LINE2;
import static org.wikipedia.Input.LINE3;
import static org.wikipedia.Input.LINE4;
import static org.wikipedia.Input.LINE5;
import static org.wikipedia.Input.LINE6;
import static org.wikipedia.Input.LINE7;

/**
 *
 * @author varjunan
 */
public class Sentences {

    private final List<String> paraSentences = Arrays.stream(LINE1.split("\\.")).map(String::trim).collect(toList());
    private final List<String> questions = new ArrayList<>();
    private final List<String> answers = Arrays.asList(LINE7.split(";"));

    private Sentences() {
        questions.add(LINE2);
        questions.add(LINE3);
        questions.add(LINE4);
        questions.add(LINE5);
        questions.add(LINE6);
    }

    public static Sentences create() {
        return new Sentences();
    }

    public List<String> getParaSentences() {
        //paraSentences.forEach(System.out::println);
        return paraSentences;
    }

    public List<String> getQuestions() {
        //questions.forEach(System.out::println);
        return questions;
    }

    public List<String> getAnswers() {
        //answers.forEach(System.out::println);
        return answers;
    }
}
