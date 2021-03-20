package com.eplusing.demo.db.mysql;

public class MysqlDemo {

    /**
     *mysql的支持的存储引擎， 通过show engines; 可查看mysql支持的存储引擎
     * 表 1 MySQL 的存储引擎
     * 存储引擎	描述
     * 1. ARCHIVE	用于数据存档的引擎，数据被插入后就不能在修改了，且不支持索引。
     *      如果只有INSERT和SELECT操作，可以选择Archive，Archive支持高并发的插入操作，但是本身不是事务安全的。
     *      Archive非常适合存储归档数据，如记录日志信息可以使用Archive
     * 2. CSV	在存储数据时，会以逗号作为数据项之间的分隔符。
     * 3. BLACKHOLE	会丢弃写操作，该操作会返回空内容。
     * 4. FEDERATED	将数据存储在远程数据库中，用来访问远程表的存储引擎。
     * 5. InnoDB	具备外键支持功能的事务处理引擎，
     *      支持ACID事务，支持事务的四种隔离级别，支持行级锁和外键约束，因此可以支持并发写
     * 6. MEMORY	置于内存的表，临时存放数据，数据量不大，并且不需要较高的数据安全性，
     *         可以选择将数据保存在内存中的Memory引擎，MySQL中使用该引擎作为临时表，存放查询的中间结果。
     *         当不再需要MEMORY表的内容时，要释放被MEMORY表使用的内存，应该执行DELETE FROM或TRUNCATE TABLE，或者删除整个表（使用DROP TABLE）
     * 7. MERGE	用来管理由多个 MyISAM 表构成的表集合
     * 8. MyISAM主要的非事务处理存储引擎，
     *      优点:适用于读多写少，每次查询都是原子的，缺点：不支持事务，每次查询都是原子的，支持表级锁，每次操作是对整个表加锁
     *      是ISAM的扩展，提供了isam没有的索引和字段管理的功能，是mysql默认的存储引擎。ISAM,优点：适用于读多写少，缺点：不支持事务，容错性差，MyISAM，
     * 9. NDB	MySQL 集群专用存储引擎
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

}
