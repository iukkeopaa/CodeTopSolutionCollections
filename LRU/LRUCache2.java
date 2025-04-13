package LRU;

import java.util.LinkedHashMap;

/**
 * @Description: LRU缓存设计
 * @Author: wjh
 * @Date: 2025/4/10 下午4:29
 */
public class LRUCache2 {

    int cap;

    LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();

    public LRUCache2(int cap){

        this.cap=cap;
    }

    public int get(int key){

        if (!cache.containsValue(key)){

            return -1;

        }

        makeRecently(key);

        return cache.get(key);
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, val);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, val);
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);

        }



}

