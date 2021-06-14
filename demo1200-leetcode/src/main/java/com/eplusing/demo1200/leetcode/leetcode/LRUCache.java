package com.eplusing.demo1200.leetcode.leetcode;

import java.util.*;


public class LRUCache {
    public static void main(String[] args) {
        int[][] oprs = {{1, 1, 1},
                {1, 2, 2},
                {1, 3, 2},
                {2, 1},
                {1, 4, 4},
                {2, 2}
        };

        int[] result = new LRUCache().LRU(oprs, 3);

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        maxSize = k;
        int len = operators.length;
        if (len == 0 || k == 0) {
            return null;
        }

        List<Integer> resultList = new ArrayList<Integer>();
        //遍历输入
        for (int i = 0; i < len; i++) {
            int[] tempArr = operators[i];

            //set
            if (tempArr[0] == 1) {
                //cacheMap.put(tempArr[1], new LRUNode(tempArr[1], tempArr[2]));
                put(tempArr[1], tempArr[2]);
            }
            //get
            else if (tempArr[0] == 2) {
                if (get(tempArr[1]) == null) {
                    resultList.add(-1);
                } else {
                    resultList.add(get(tempArr[1]));
                }
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }


    static Map<Integer, LRUNode> cacheMap = new HashMap<>();
    static int maxSize;
    static boolean init = false;
    static int curSize = 0;
    static LRUNode head = new LRUNode(0, Integer.MAX_VALUE);
    static LRUNode tail = new LRUNode(0, Integer.MAX_VALUE);

    static {
        head.next = tail;
        tail.pre = head;
    }


    private static class LRUNode {
        LRUNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        Integer key;
        Integer value;
        LRUNode pre;
        LRUNode next;
    }

    private static void put(Integer key, Integer value) {

        if (cacheMap.get(key) == null) {
            LRUNode newNode = new LRUNode(key, value);
            cacheMap.put(key, newNode);
            curSize++;
            //将新节点加到队首
            addNew(newNode);
            if (curSize > maxSize) {
                //淘汰末位
                deleteTail();
                curSize--;
            }
        } else {
            //将该节点移至队首
            moveTohead(cacheMap.get(key));
        }
    }

    private static Integer get(Integer key) {
        LRUNode node = cacheMap.get(key);
        if (node != null) {
            //将新节点加到队首
            moveTohead(node);
            return node.value;
        } else {
            return null;
        }
    }


    private static void moveTohead(LRUNode oldNode) {
        LRUNode oldNodePre = oldNode.pre;
        LRUNode oldNodeNext = oldNode.next;

        oldNodePre.next = oldNodeNext;
        oldNodeNext.pre = oldNodePre;

        addNew(oldNode);
    }

    //新增节点
    private static void addNew(LRUNode newNode) {
        LRUNode tempNode = head.next;
        head.next = newNode;
        newNode.pre = head;

        newNode.next = tempNode;
        tempNode.pre = newNode;
    }

    private static void deleteTail() {
        LRUNode tempNode = tail.pre;
        tail.pre = tempNode.pre;
        tempNode.pre.next = tail;
        cacheMap.remove(tempNode.key);
    }
}