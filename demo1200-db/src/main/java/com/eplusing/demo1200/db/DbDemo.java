package com.eplusing.demo1200.db;

public class DbDemo {

    /***
     * 数据库三范式
     * 1.第一范式，是对属性的原子行约束，即属性不可再分
     * 2.第二范式，在满足第一范式下，要求记录要有唯一标识， 即实体的唯一性
     * 3.第三范式，在满足第二范式下，对字段冗余的约束，任何字段不能有其他字段派生出来
     *
     *
     * 三范式优点：减少数据冗余，使得更新快，体积小
     * 缺点：查询需要多表关联，降低写的效率，不易经行索引优化
     *
    *
     * */


    /**
     *事务：事务是用户定义的一个数据库操作序列，这些操作要么全做，要么全不做，是一个不可分割的执行单位。
     *
     * 事务回滚，将该事务已经完成的对数据库的操作做撤销。
     *
     * */

    /**
     * 事务的特性ACID：
     * 1. Atomitic,原子性，事务是数据库操作的逻辑单元，事务中的操作要么全做要么全不做，是不可分割。
     *
     * 2. Consistency,一致性，数据库事务执行的结果必须是从一个一致性状态变为另一个一致性状态，数据库只有成功事务提交的结果，
     *
     * 3. Isolation,隔离性，一个事务的执行不会受其他事务的干扰，之间是隔离的
     *
     * 4. Durability, 持久性，一个事务提交后对数据库的改变是永久的
     *
     * **/

    //数据库恢复，数据库管理系统必须把数据库从错误状态恢复到某种已知的正确状态，这就是数据库恢复系统对故障的对策。


    /**
     * 数据库的隔离级别 ，大多数数据库默认的事务隔离级别是Read committed，比如Sql Server , Oracle。Mysql的默认隔离级别是Repeatable read。
     * 1. read uncommitted,读未提交，可能出现脏读，可以事务的隔离级别改为读已提交解决脏读问题。
     *
     * 2. read committed，读已提交，可能出现不可重复读，即一个事务内的两次查询结果不一致，
     * 对应的在该事务操作过程中有另外一个事务进行了update操作。可重复读可解决不可重复读问题。
     *
     * 3. repeatable read，可重复读，事务开启时不允许再修改已读的数据，可能出现幻读，对应的是另外的事务进行了insert操作。串行操作可解决幻读。
     *
     * 4. serializable，串行操作，事务串行化执行，这种事务隔离级别效率底下,比较耗数据库性能，一般不使用
     *
     *
     * */

    /**
     * Spring事务的传播行为
     * PROPAGATION_REQUIRED--支持当前事务，如果当前没有事务，就新建一个事务,最常见的选择。
     * PROPAGATION_SUPPORTS--支持当前事务，如果当前没有事务，就以非事务方式执行。
     * PROPAGATION_MANDATORY--支持当前事务，如果当前没有事务，就抛出异常。
     * PROPAGATION_REQUIRES_NEW--新建事务，如果当前存在事务，把当前事务挂起, 两个事务之间没有关系，一个异常，一个提交，不会同时回滚
     * PROPAGATION_NOT_SUPPORTED--以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * PROPAGATION_NEVER--以非事务方式执行，如果当前存在事务，则抛出异常
     *
     * */

}
