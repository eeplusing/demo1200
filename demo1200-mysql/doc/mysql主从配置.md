
MySQL 主从复制的方式有多种，下面仅是基于基于日志（binlog）的主从复制方式。
https://blog.csdn.net/zyhlwzy/article/details/80569422
https://www.cnblogs.com/honeylemon/p/10591899.html


1.MySQL 主从复制（也称 A/B 复制） 的原理
1.1Master将数据改变记录到二进制日志(binary log)中，也就是配置文件log-bin指定的文件，
这些记录叫做二进制日志事件(binary log events)；

1.2 Slave 通过 I/O 线程读取 Master 中的 binary log events 并写入到它的中继日志(relay log)；

1.3 Slave 重做中继日志中的事件， 把中继日志中的事件信息一条一条的在本地执行一次，完
成数据在本地的存储， 从而实现将改变反映到它自己的数据(数据重放)。

2. 主从配置需要注意的点
2.1 主从服务器操作系统版本和位数一致；
2.2 Master 和 Slave 数据库的版本要一致；
2.3 Master 和 Slave 数据库中的数据要一致；
2.4 Master 开启二进制日志， Master和Slave各自的 server_id 在局域网内必须唯一；

3. 主从配置的简要步骤
Master上的配置
安装数据库；
3.1 修改数据库配置文件，指明server_id，开启二进制日志(log-bin)；
3.2 启动数据库，查看当前是哪个日志，position 号是多少；
3.3 登录数据库，授权数据复制用户（IP 地址为从机 IP 地址， 如果是双向主从， 这里的还需要授权本机的 IP 地址， 此时自己的 IP 地址就是从 IP 地址)；
3.4 备份数据库（记得加锁和解锁；
3.5 传送备份数据到Slave上；
3.6 启动数据库；

以下步骤，为单向主从搭建成功，想搭建双向主从需要的步骤：
3.7 登录数据库，指定 Master 的地址、 用户、 密码等信息（此步仅双向主从时需要）；
3.8 开启同步，查看状态；


4. Slave 上的配置
4.1 安装数据库；
4.2 修改数据库配置文件， 指明 server_id（如果是搭建双向主从的话， 也要开启二进制日志 log-bin）；
4.3 启动数据库， 还原备份；
4.4 查看当前是哪个日志， position 号是多少（单向主从此步不需要， 双向主从需要）；
4.5 指定 Master 的地址、 用户、 密码等信息；
4.6 开启同步， 查看状态。

########################具体修改的配置文件和操作步骤####################

mysql版本：mysql-8.0.26-linux-glibc2.12-x86_64
主节点：192.168.145.129
从节点：192.168.145.130

###Master配置###
1.主节（Master）点配置
修改 Master 的配置文件/etc/my.cnf
vi /etc/my.cnf
在my.cnf文件中加入如下配置内容
[mysqld]
log-bin=mysql-bin
server-id=1

2. 启动从节点
support-files/mysql.server start

3. 创建用于复制操作的用户
3.1 在主节点创建一个用户replicate，用于从节点链接主节点时使用。
   mysql>CREATE USER 'replicate'@'%' IDENTIFIED WITH mysql_native_password BY 'replicate';
   mysql>GRANT REPLICATION SLAVE ON *.* TO 'replicate'@'%';

3.2 刷新授权表信息
   mysql> flush privileges;

3.3 获取主节点当前binary log文件名和位置（position）
mysql> show master status;
+---------------+----------+--------------+------------------+-------------------+
| File          | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+---------------+----------+--------------+------------------+-------------------+
| binlog.000005 |     1282 |              |                  |                   |
+---------------+----------+--------------+------------------+-------------------+
1 row in set (0.00 sec)


###Slave配置###
1. 从节点（Slave）配置
修改 Slave 的配置文件/etc/my.cnf

vi /etc/my.cnf
在my.cnf文件中加入如下配置内容
[mysqld]
server-id=2

2. 启动从节点
support-files/mysql.server start

3. 登录从节点本地,在从（Slave）节点上设置主节点参数
mysql> CHANGE MASTER TO
MASTER_HOST='192.168.145.129',
MASTER_USER='replicate',
MASTER_PASSWORD='replicate',
MASTER_LOG_FILE='binlog.000005',
MASTER_LOG_POS=1282;

4. 查看主从同步状态
mysql> show slave status\G;

5. 开启主从同步
mysql> start slave;

6.再查看主从同步状态
mysql> show slave status\G;
mysql> show slave status\G;
*************************** 1. row ***************************
               Slave_IO_State: Waiting for source to send event
                  Master_Host: 192.168.145.129
                  Master_User: replicate
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: binlog.000005
          Read_Master_Log_Pos: 3292
               Relay_Log_File: localhost-relay-bin.000002
                Relay_Log_Pos: 2331
        Relay_Master_Log_File: binlog.000005
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 3292
              Relay_Log_Space: 2544
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
        Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 1
                  Master_UUID: d36a9e62-f2c0-11eb-a302-000c29ef2a25
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: Replica has read all relay log; waiting for more updates
           Master_Retry_Count: 86400
                  Master_Bind:
      Last_IO_Error_Timestamp:
     Last_SQL_Error_Timestamp:
               Master_SSL_Crl:
           Master_SSL_Crlpath:
           Retrieved_Gtid_Set:
            Executed_Gtid_Set:
                Auto_Position: 0
         Replicate_Rewrite_DB:
                 Channel_Name:
           Master_TLS_Version:
       Master_public_key_path:
        Get_master_public_key: 0
            Network_Namespace:

开启主从之后，状态如下则说明主从信息就已经配置好了

               Slave_IO_State: Waiting for source to send event
                  Master_Host: 192.168.145.129
                  Master_User: replicate
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: binlog.000005
              ......
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes




查看状态时，可能会出现I/O任务启动失败的情况，即如下错误:
Last_IO_Error: Fatal error: The slave I/O thread stops because master and slave have equal MySQL server ids; these ids must be different for replication to work (or the –replicate-same-server-id option must be used on slave but this does not always make sense; please check the manual before using it).
这是因为在MySQL主从结构中，从机上的server_id和主机上的server_id不能相同，我们可以看一下主机上的server_id和从机上的server_id是否相同。
mysql> show variables like 'server_id';
mysql> set global server_id=2; #此处的数值和my.cnf里设置的一样就行

