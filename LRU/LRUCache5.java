package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/10 下午4:57
 */

class DLinkedNode2 {
    int key;
    int value;
    long expirationTime;
    DLinkedNode2 prev;
    DLinkedNode2 next;

    public DLinkedNode2() {}

    public DLinkedNode2(int key, int value, long expirationTime) {
        this.key = key;
        this.value = value;
        this.expirationTime = expirationTime;
    }
}

public class  LRUCache5 {
    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode2> cache = new HashMap<>();
    private DLinkedNode2 head;
    private DLinkedNode2 tail;

    public LRUCache5(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode2();
        tail = new DLinkedNode2();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode2 node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 检查是否过期
        if (isExpired(node)) {
            removeNode(node);
            cache.remove(key);
            size--;
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value, long expirationTime) {
        DLinkedNode2 node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode2 newNode = new DLinkedNode2(key, value, expirationTime + System.currentTimeMillis());
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode2 removed = removeTail();
                // 删除哈希表中对应的项
                cache.remove(removed.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value 和过期时间，并移到头部
            node.value = value;
            node.expirationTime = expirationTime + System.currentTimeMillis();
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode2 node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode2 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode2 node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode2 removeTail() {
        DLinkedNode2 res = tail.prev;
        removeNode(res);
        return res;
    }

    private boolean isExpired(DLinkedNode2 node) {
        return System.currentTimeMillis() > node.expirationTime;
    }
}
