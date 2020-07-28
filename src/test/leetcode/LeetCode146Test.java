package leetcode;


import org.junit.jupiter.api.Test;

class LeetCode146Test {
    @Test
    public void test1() {
        LeetCode146 cache = new LeetCode146( 3 /* 缓存容量 */ );
        Integer rst = -100;
        cache.put(1, 1);
        System.out.println("null");
        cache.put(2,2);
        System.out.println("null");
        cache.put(3,3);
        System.out.println("null");
        cache.put(4,4);
        System.out.println("null");
        rst = cache.get(4);
        System.out.println(rst);
        rst = cache.get(3);
        System.out.println(rst);
        rst = cache.get(2);
        System.out.println(rst);
        rst = cache.get(1);
        System.out.println(rst);
        cache.put(5,5);
        System.out.println("null");
        rst = cache.get(1);
        System.out.println(rst);
        rst = cache.get(2);
        System.out.println(rst);
        rst = cache.get(3);
        System.out.println(rst);
        rst = cache.get(4);
        System.out.println(rst);
        rst = cache.get(5);
        System.out.println(rst);
    }

    @Test
    public void test2() {
        LeetCode146 cache = new LeetCode146( 1 /* 缓存容量 */ );

        Integer rst = -100;
        cache.put(2, 1);
        System.out.println("null");
        rst = cache.get(2);
        System.out.println(rst);
        cache.put(3, 2);
        System.out.println("null");
        rst = cache.get(2);
        System.out.println(rst);
        rst = cache.get(3);
        System.out.println(rst);
    }
}
