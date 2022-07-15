卸载已安装mysql:
yum list installed mysql*
yum remove mysql.x86_64 mysql-common.x86_64 mysql-devel.x86_64 mysql-errmsg.x86_64 mysql-libs.x86_64  mysql-server.x86_64
创建用户：
groupadd mysql
useradd -r -d /home/mysql -g mysql mysql
mkdir -p /home/mysql
mkdir -p /usr/local/mysql
chown -R mysql:mysql /home/mysql
chown -R mysql:mysql /usr/local/mysql


下载安装包：
https://cdn.mysql.com//Downloads/MySQL-8.0/mysql-8.0.27-linux-glibc2.12-x86_64.tar.xz

配置my.cnf文件
vi /etc/my.cnf
新建my.cnf配置文件，并添加以下内容

[mysqld]
port=3306
basedir=/usr/local/mysql
datadir=/usr/local/mysql/data
log-error=/usr/local/mysql/data/error.log
socket=/tmp/mysql.sock
pid-file=/usr/local/mysql/data/mysql.pid
character-set-server = utf8
lower_case_table_names=1
innodb_log_file_size=1G
default-storage-engine=INNODB
default_authentication_plugin=mysql_native_password

[client]
port=3306
default-character-set=utf8


初始化：
bin/mysqld --initialize --user mysql



查看初始密码：
less data/error.log
2021-08-01T12:05:59.597134Z 6 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: u(Xp&784!)ad


sudo ln -s /usr/lib64/libtinfo.so.6.1 /usr/lib64/libtinfo.so.5


启动mysql:
support-files/mysql.server start


ERROR 1820 (HY000): You must reset your password using ALTER USER statement before executing this statement.
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '150906@cpp';


修改密码;

 alter user 'root'@'localhost' identified by 'root';

查看root权限
 show grants for 'root'@'localhost';


创建远程root用户：
create user 'root'@'%' identified by 'root';

修改用户：
update user set
Select_priv='Y',
Insert_priv='Y',
Update_priv='Y',
Delete_priv='Y',
Create_priv='Y',
Drop_priv='Y',
Reload_priv='Y',
Shutdown_priv='Y',
Process_priv='Y',
File_priv='Y',
Grant_priv='Y',
References_priv='Y',
Index_priv='Y',
Alter_priv ='Y',
Show_db_priv='Y',
Super_priv='Y',
Create_tmp_table_priv ='Y',
Lock_tables_priv ='Y',
Execute_priv='Y',
Repl_slave_priv ='Y',
Repl_client_priv='Y',
Create_view_priv ='Y',
Show_view_priv ='Y',
Create_routine_priv ='Y',
Alter_routine_priv='Y',
Create_user_priv='Y',
Event_priv ='Y',
Trigger_priv ='Y',
Create_tablespace_priv ='Y',
Create_role_priv ='Y',
Drop_role_priv ='Y'
where user = 'root' and host='%';

刷新权限:
flush privileges;

添加开机启动：
cp support-files/mysql.server /etc/init.d/mysqld
chkconfig --add mysqld
chkconfig --list





mysql8.0.27修改密码：
ALTER USER 'root'@'localhost' IDENTIFIED WITH caching_sha2_password BY '150906@Cpp';

