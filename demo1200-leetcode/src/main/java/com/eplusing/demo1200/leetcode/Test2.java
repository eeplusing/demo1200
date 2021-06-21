package com.eplusing.demo1200.leetcode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * *
 * *
 * * 2. 记账过程中，热点账号的问题解决
 * * void transferOut(String srcAccout, BigDecimal ammount)
 */
public class Test2 {

    //合并记账数
    private static final int BATCH_NUM = 100;
    private static ConcurrentHashMap<Integer, BigDecimal> map = new ConcurrentHashMap();

    //TODO初始化
    private static HashMap hotMap = new HashMap();
    AtomicInteger num = new AtomicInteger();

    synchronized void transferOut(String srcAccout, BigDecimal ammount) {
        //检查入参
        if (srcAccout == null || srcAccout.length() == 0) {
            return;
        }
        if (ammount.compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }

        //热点账户
        if (hotMap.containsKey(srcAccout)) {
            //临时存入
            if (map.size() < BATCH_NUM) {
                map.put(num.getAndAdd(1), ammount);
                return;
            }

            BigDecimal subAmount = BigDecimal.ZERO;
            for (BigDecimal amt : map.values()) {
                subAmount = subAmount.add(amt);
            }
            //重置map
            map = new ConcurrentHashMap();
            num = new AtomicInteger(0);

            ammount = subAmount;
        }

 /*       //查询账户当前余额
        BigDecimal balance = loadCurrentBalance(srcAccout);
        if (balance.compareTo(ammount) < 0) {
            return;
        }

        BigDecimal currentBalance = balance.subtract(ammount);

        //更新余额
        updateCurrentBanlace(currentBalance);*/
    }

}
