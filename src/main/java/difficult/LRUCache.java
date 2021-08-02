/*
 * Copyright (C) 2021 Baidu, Inc. All Rights Reserved.
 */


/***
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 *
 */

package difficult;



import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size = 0;
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {

        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.after = tail;
        tail.before =  head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);

        if (node != null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);
        DLinkedNode newNode = new DLinkedNode(key, value);

//        cache.put(key, newNode);

        if (node == null) {
            size++;
            addToHead(newNode);
            if (size > capacity) {
                removeTail();
                size--;
            }
            cache.put(key, newNode); // cache 放的v要注意其前后指针建立完之后 再放入
        } else {
            node.value = value;
            moveToHead(node); // cache 放的v要注意其前后指针建立完之后 再放入 因为node 再move的时候要看前后指针
            cache.put(key, node);
        }



    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode next = head.after;
        node.before = head;
        node.after = next;
        head.after = node;

        if (next != null) {
            next.before = node;
        }
    }


    // 删除双向链表尾部节点
    private void removeTail() {
        DLinkedNode tailNode = tail.before;


//        DLinkedNode b = tailNode.before;
//        DLinkedNode a = tailNode.after;
//
//        int k= tailNode.key;
//        cache.remove(k);
//
//        b.after = a;
//        a.before = b;

        if (tailNode != null) {

            int k= tailNode.key;
            cache.remove(k);

            DLinkedNode b = tailNode.before;
            if (b != null) {
                b.after = tail;
                tail.before = b;
            } else {
                tail.before = b;
            }
            tailNode.before = null;
        }
    }


    private void  moveToHead(DLinkedNode node) {


        DLinkedNode a = node.after;
        DLinkedNode b = node.before;

        node.after = null;

        // 建立a与b的关系
        if (a == null) { // 这里初始化 tail head 都为具体的node节点了 所以要省去判空 是与源码不同的地方
            tail.after = b;
        } else {
            a.before = b;
        }

        if (b == null) {
            head.after = a;
        } else {
            b.after = a;
        }

        // 建立node 与 head的关系
        addToHead(node);

    }

    class DLinkedNode {
        int key, value;
        DLinkedNode before, after;
        public DLinkedNode() {}

        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(10);
        lRUCache.put(10,13);
        lRUCache.put(3,17);
        lRUCache.put(6,11);
        lRUCache.put(10,5);
        lRUCache.put(9,10);

        lRUCache.put(2,19);
        lRUCache.put(5,25);
        lRUCache.put(9,22);
        lRUCache.put(5,5);
        lRUCache.put(1,30);

        lRUCache.put(9,12);
        lRUCache.put(4,30);
        lRUCache.put(9,3);
        lRUCache.put(6,14);
        lRUCache.put(3, 1);

        lRUCache.put(10,11);
        lRUCache.put(2,14);
        lRUCache.put(11,4);
        lRUCache.put(12,24);
        lRUCache.put(5,18);
        lRUCache.put(7,23);

        lRUCache.put(3,27);

        lRUCache.put(2,12);
        lRUCache.put(2,9);
        lRUCache.put(13,4);
        lRUCache.put(8,18);
        lRUCache.put(1,7);



        System.out.println(lRUCache.get(6));

    }
}