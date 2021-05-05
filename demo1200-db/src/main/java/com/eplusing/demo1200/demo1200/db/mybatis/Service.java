package com.eplusing.demo1200.demo1200.db.mybatis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class Service {
    @Autowired
    User2Mapper userMapper;

    /**
     *
     * Transantional相关属性
     * 属性	                类型	                            描述
     * value	            String	                        可选的限定描述符，指定使用的事务管理器
     * propagation	        enum: Propagation	            可选的事务传播行为设置
     * isolation	        enum: Isolation	                可选的事务隔离级别设置
     * readOnly	            boolean	                        读写或只读事务，默认读写
     * timeout	            int (in seconds granularity)	事务超时时间设置
     * rollbackFor	        Class对象数组，必须继承自Throwable	导致事务回滚的异常类数组
     * rollbackForClassName	类名数组，必须继承自Throwable	    导致事务回滚的异常类名字数组
     * noRollbackFor	    Class对象数组，必须继承自Throwable	不会导致事务回滚的异常类数组
     * noRollbackForClassName	类名数组，必须继承自Throwable	不会导致事务回滚的异常类名字数组
     *
     ***/

    @Transactional(isolation=Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int addAccount() {
        User2 user = new User2();
        user.setName("事务测试");
        user.setPhone("000121212");
        userMapper.insert(user);
        int a = 1/0;
        return user.getId();
    }
}
