package com.lia.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liqu on 10/29/16.
 */
public class InvertedIndex {
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (Document doc : docs) {
            String[] terms = doc.content.split("\\s+");
            for (String term : terms) {
                if (!map.containsKey(term)) {
                    map.put(term, new ArrayList<Integer>());
                }
                if (!map.get(term).contains(doc.id)) {
                    map.get(term).add(doc.id);
                }
            }
        }
        return map;
    }
}
