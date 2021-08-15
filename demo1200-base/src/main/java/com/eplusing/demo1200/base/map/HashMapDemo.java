package com.eplusing.demo1200.base.map;

import java.util.HashMap;

public class HashMapDemo {
    /**
     * 初始容量，
     * 负载因子,默认0.75
     * 通常建议能提前预估 HashMap 的大小最好，尽量的减少扩容带来的性能损耗
     * jdk7,hashmap的存储是数组+链表
     * jdk,hashmap的存储是数组+链表或红黑树，当链表大于预设的阈值时TREEIFY_THRESHOLD则转红黑树，
     * 链表转红黑树：
     *
     *
     *     final void treeifyBin(Node<K,V>[] tab, int hash) {
     *         int n, index; Node<K,V> e;
     *         if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
     *             resize();
     *         else if ((e = tab[index = (n - 1) & hash]) != null) {
     *             TreeNode<K,V> hd = null, tl = null;
     *             do {
     *                 TreeNode<K,V> p = replacementTreeNode(e, null);
     *                 if (tl == null)
     *                     hd = p;
     *                 else {
     *                     p.prev = tl;
     *                     tl.next = p;
     *                 }
     *                 tl = p;
     *             } while ((e = e.next) != null);
     *             if ((tab[index] = hd) != null)
     *                 hd.treeify(tab);
     *         }
     *     }
     * */

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("a", 1);
        map.get("a");
    }

}
