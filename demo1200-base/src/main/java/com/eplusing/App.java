package com.eplusing;

/**
 * Hello world!
 * <p>
 * <p>
 * /*
 * 问题：⽤java编写⼀个资⾦转账接⼝：传⼊转出账号、转⼊账号、转账⾦额3个参数，完成转出和转⼊账号的资⾦
 * 处理，该服务要确保在资⾦处理时转出账户的余额不会透⽀，⾦额计算准确，能够⽀撑⾼并发转账场景。
 * <p>
 * <p>
 * <p>
 * TopN算法，百亿整数分布在100个文件，如何找到前1000出现次数最多的数？
 * 写出思路即可
 * 数据量较大，不能全部加载到内中中进行操作，使用分治
 * 1.单独加载每个文件单独，统计出现最多的1000个数
 * 2.再将这100各结果及汇总，统计出现最多的top1000。
 * 3.
 * <p>
 * <p>
 * 1.先将100各文件，遍历一遍，进行内容的重新分割
 * 2.对每个文件里的数字进行hash,这样将同一个数据分割到同一个文件中，得到重新编制后的100各文件
 * 3.从第二不得到的文件可以保证，不同的文件中不会出现存储相同的整数
 * 4.这100各小文件可以单独进行处理，统计每个该文件内的数字
 * 5.找出每个小文件中个数top1000的整数
 * 6.
 */

import java.math.BigDecimal;


public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

/***
 *
 * /*
 *  问题：⽤java编写⼀个资⾦转账接⼝：传⼊转出账号、转⼊账号、转账⾦额3个参数，完成转出和转⼊账号的资⾦
 * 处理，该服务要确保在资⾦处理时转出账户的余额不会透⽀，⾦额计算准确，能够⽀撑⾼并发转账场景。
 * */
 *
         *

    public Boolean transfer(String srcAccout, String destAccount, BigDecimal ammount) {
 *         //1.查询本方账户可用余额
 *
 *if (balance.compareTo(ammount) > 0) {
 *synchronized (this) {
 *                 //BigDecimal balance =  query(srcAccout);
 *                    //BigDecimal balance =  query(srcAccout);
 *BigDecimal srcBalance = new BigDecimal(10000);//假设查到的可用余额10000
 *BigDecimal destBalance = new BigDecimal(10000);//假设查到的可用余额10000
 *
 *try {
 *                     //本方账户减金额
 *srcBalance.subtract(ammount);
 *                     //减异常，返回false
 *
 *                     //对方账户加金额
 *destBalance.add(ammount);
 *                     //加异常返回false
 *} catch (Exception e) {
 *
 *                   //check srcAccout balance
 *                   //cehck destAccount balance
 *if (success) {
 *                     //如果成功
 *                    //return true;
 *} else {
 *if ( //如果本方账户减成功，对方未收到){
 *srcBalance.add(ammount);
 *                       //update //本方账户发起退票
 *return false;
 *}
 *
 *if ( //如果本方账户减未成功，对方账户冲正){
 *
 *                       //对方账户冲正
 *return false;
 *}
 *
 *                      //throw BusinessException();
 *
 *}
 *
 *
 *
 *
 *}
 *
 *}
 *
} else{
        *return false;
        *}
        *
        *
        *return true;
        *}
        *
        *
        *
        *
        *
        *
        *
        *
        * /*
 *  问题：TopN算法，百亿整数分布在100个文件，如何找到前1000出现次数最多的数？
 *  写出思路即可
 * */
        *
        *
        *
        *1.先将100各文件，遍历一遍，进行内容的重新分割
        **2.对每个文件里的数字进行hash,这样将同一个数据分割到同一个文件中，得到重新编制后的100各文件
        **3.从第二不得到的文件可以保证，不同的文件中不会出现存储相同的整数
        **4.这100各小文件可以单独进行处理，统计每个该文件内的数字
        **5.找出每个小文件中个数top1000的整数，快排
        **6.再把100个top1000找出结果
        **
 *
 *
 * */


    public Boolean transfer(String srcAccout, String destAccount, BigDecimal ammount) {
        //1.查询本方账户可用余额
        if (balance.compareTo(ammount) > 0) {
            synchronized (this) {
                //BigDecimal balance =  query(srcAccout);
                //BigDecimal balance =  query(srcAccout);
                BigDecimal srcBalance = new BigDecimal(10000);//假设查到的可用余额10000
                BigDecimal destBalance = new BigDecimal(10000);//假设查到的可用余额10000


                try {
                    //本方账户减金额
                    balance.subtract(ammount);
                    //减异常，返回false

                    //对方账户加金额
                    destBalance.add(ammount);
                    //加异常返回false
                } catch (Exception e) {

                    //check srcAccout  destAccount balance
                    //throw
                    //BusinessException();
                }

            }
        } else {
            return false;
        }


        return true;
    }


}
