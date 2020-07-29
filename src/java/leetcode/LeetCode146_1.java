package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU实现
 */
public class LeetCode146_1 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LeetCode146_1(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > LeetCode146_1.this.capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
