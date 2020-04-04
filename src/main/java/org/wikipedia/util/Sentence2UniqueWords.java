package org.wikipedia.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author varjunan
 */
public class Sentence2UniqueWords {

    public static Set<String> convert(String sentence) {
        return new HashSet<>(Arrays.asList(sentence
                .replaceAll(",", " ")
                .replaceAll("\\?", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .split("\\s")));
    }
}
