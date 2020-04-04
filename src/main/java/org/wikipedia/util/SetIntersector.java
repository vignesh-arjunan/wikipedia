package org.wikipedia.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author VARJUNAN
 */
public class SetIntersector {

    public static <T> Set<T> intersect(Set<T> set1, Set<T> set2) {
        Set<T> output = new HashSet<>(set1);
        output.retainAll(set2);
        return output;
    }
}
