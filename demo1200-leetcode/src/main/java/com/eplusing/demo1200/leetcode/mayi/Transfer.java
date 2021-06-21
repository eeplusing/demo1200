package com.eplusing.demo1200.leetcode.mayi;

import java.math.BigDecimal;

public class Transfer {


    /*
 问题：⽤java编写⼀个资⾦转账接⼝：传⼊转出账号、转⼊账号、转账⾦额3个参数，完成转出和转⼊账号的资⾦
处理，该服务要确保在资⾦处理时转出账户的余额不会透⽀，⾦额计算准确，能够⽀撑⾼并发转账场景。
*/


    public synchronized Boolean transfer(String srcAccout, String destAccount, BigDecimal ammount) {
        if (ammount.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        boolean isSuccess = sub(srcAccout, ammount);

        if (!isSuccess) {
            return false;
        }
        isSuccess = add(destAccount, ammount);

        if (!isSuccess) {
            add(srcAccout, ammount);
            return false;
        }

        return true;
    }

    private boolean sub(String srcAccout, BigDecimal ammount) {
        //ammount.subtract()

        return false;
    }

    private boolean add(String destAccount, BigDecimal ammount) {
        return false;
    }


}