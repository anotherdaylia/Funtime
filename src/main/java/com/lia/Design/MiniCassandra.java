package com.lia.Design;

import java.util.*;

/**
 * Cassandra is a NoSQL storage. The structure has two-level keys.

 Level 1: raw_key. The same as hash_key or shard_key.
 Level 2: column_key.
 Level 3: column_value
 raw_key is used to hash and can not support range query. let's simplify this to a string.
 column_key is sorted and support range query. let's simplify this to integer.
 column_value is a string. you can serialize any data into a string and store it in column value.

 implement the following methods:

 insert(raw_key, column_key, column_value)
 query(raw_key, column_start, column_end) // return a list of entries

 * Created by liqu on 10/26/16.
 */
public class MiniCassandra {
    private Map<String, TreeMap<Integer, Column>> cassandra;

    public MiniCassandra() {
        this.cassandra = new HashMap<>();
    }

    /**
     * @param raw_key a string
     * @return void
     */
    public void insert(String raw_key, int column_key, String column_value) {
        if (!cassandra.containsKey(raw_key)) {
            cassandra.put(raw_key, new TreeMap<Integer, Column>());
        }
        cassandra.get(raw_key).put(column_key, new Column(column_key, column_value));
    }

    /**
     * @param raw_key a string
     * @param column_start an integer
     * @param column_end an integer
     * @return a list of Columns
     */
    public List<Column> query(String raw_key, int column_start, int column_end) {
        List<Column> result = new ArrayList<>();
        if (!cassandra.containsKey(raw_key)) return result;

        NavigableMap<Integer, Column> colMap = cassandra.get(raw_key).subMap(column_start, true, column_end, true);
        for (Column column : colMap.values()) {
            result.add(column);
        }
        return result;
    }

    class Column {
        public int key;
        public String value;
        public Column(int key, String value) {
            this.key = key;
            this.value = value;
         }
     }
}
