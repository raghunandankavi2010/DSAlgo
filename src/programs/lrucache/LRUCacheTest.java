package programs.lrucache;

import java.util.*;

public class LRUCacheTest {
    public static void main(String... args) {
        Map<Integer, String> cache = new LRUCache<>(5);

        for (int i = 0; i < 5; i++) {
            cache.put(i, "hi");
        }
        cache.put(6,"hi");
        cache.put(7,"hi");

        printCache(cache);

        String two = cache.get(2);

        System.out.println("Two....."+two);

        printCache(cache);

        cache.put(8,"hi");
        System.out.println(".........................");

        printCache(cache);



//
//        Map.Entry<Integer, String> next = it.next();
//        System.out.println("Item : "+next.getKey()+" Deleted : "+cache.remove(next.getKey()));
    }

    private static void printCache(Map<Integer, String> cache) {
        Iterator<Map.Entry<Integer, String>> it = cache.entrySet().iterator();
        for (Map.Entry<Integer,String> entry : cache.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

}
