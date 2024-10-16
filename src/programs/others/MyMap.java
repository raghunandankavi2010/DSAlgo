package programs.others;

import java.util.Objects;

/**
 * A simple hash map implementation using array and list.
 * @param <K> key
 * @param <V> value for the key
 */
public class MyMap<K,V> {

    private Entry<K,V> entry;
    private int size = 0;
    private int capacity = 16;
    private Entry[] buckets;

    public MyMap() {
        this(16);
    }

    public MyMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[this.capacity];
    }

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int getBucketsSize(){
        return buckets.length;
    }

    public V get(K key){
        Entry<K,V> bucket = buckets[getHash(key)%getBucketsSize()]; // get index of array

        while(bucket!=null){ // loop through the list to get the value based on key
            if(key == bucket.key) {
                return bucket.value;

            }
            bucket = bucket.next;
        }
        return null;
    }

    public void put(K key,V value){
        // in case the capacity is full
        // 1. create a new array with twice the capacity
        // 2. copy old entries to new array
        // 3. add a new entry or replace old if key already exists
        if(capacity == size){

            Entry<K,V>[] old = buckets;

            capacity *=2;
            size = 0;
            buckets = new Entry[capacity];
            for(Entry<K,V> entry: old){
                while (entry != null) {
                    put(entry.key, entry.value);
                    entry = entry.next;
                }
            }

            int index = getHash(key) % getBucketsSize();

            Entry<K,V> existing = buckets[index];
            if(existing==null){ // key does not exist
                buckets[index] = entry;
                size++;
            }else {  // in case of collision
                // go through the list and check if key exists and replace value there
                while(existing.next!=null){
                    if(existing.key.equals(key)){
                        existing.value = value;
                        return;
                    }
                    existing = existing.next;
                }
                // else check if the key is same replace
                if(existing.key.equals(key)){
                    existing.value = value;

                }else { // else link a new entry to form linked list
                    existing.next = entry;
                    size++;
                }

            }
        }
    }

    static class Entry<K,V>{
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }


        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) &&
                    Objects.equals(value, entry.value) &&
                    Objects.equals(next, entry.next);
        }

        @Override
        public int hashCode() {
           int hash = 13;
           hash = 17 * hash + (key == null ? 0: key.hashCode());
           hash = 17 * hash + (value == null ? 0 : value.hashCode());
           return hash;
        }
    }
}
