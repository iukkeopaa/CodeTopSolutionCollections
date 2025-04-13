package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: LRU缓存设计
 * @Author: wjh
 * @Date: 2025/4/10 下午4:15
 */
public class LRUCache {


    private LinkedHashMap<Integer,Integer> cache;
    private int capacity;


    public LRUCache(int capacity){

        this.capacity=capacity;
        // 这里的 accessOrder 默认是为false，如果要按读取顺序排序需要将其设为 true
        // accessOrder 的值(默认 false，代表按照插入顺序排序)来确定是按插入顺序还是读取顺序排序。
        this.cache=new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){

                return size() >capacity;
            }
        };
    }

    public int get(int key){

        return cache.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        cache.put(key,value);
    }


    public static void main(String[] args){

        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回  1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3)); // 返回  3
        System.out.println(cache.get(4)); // 返回  4
    }
}

