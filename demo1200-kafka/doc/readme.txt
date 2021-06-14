迅捷流程图。

下载zookeeper地址：https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.6.3/apache-zookeeper-3.6.3.tar.gz

修改：conf/zoo.cfg
server.0=192.168.145.131:2888:3888
server.1=192.168.145.132:2888:3888
server.2=192.168.145.133:2888:3888


kafka配置：
brokerid
listner
connect，192.168.145.131:2181,192.168.145.132:2181,192.168.145.133:2181

关闭系统防火墙：
 systemctl stop firewalld.service


先启动zookeeper再启动kafka
启动zookeeper:
/usr/local/zookeeper/bin/zkServer.sh start
/usr/local/zookeeper/bin/zkServer.sh status

关闭：
zkServer.sh stop

启动kafka:
/usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties


关闭kafka:
/usr/local/kafka/bin/kafka-server-stop.sh

示例1：
通过kafka服务端脚本创建topic:
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
--partitions 1，分区数为1数据只能存储在一个broker节点。

生产消息
./bin/kafka-console-producer.sh --broker-list 192.168.145.132:9092 --topic test
消费消息
./bin/kafka-console-consumer.sh --bootstrap-server 192.168.145.132:9092 --topic test --from-beginning

实例2：
来查看所有topic
./bin/kafka-topics.sh --zookeeper localhost:2181 --list

删除topic:
./bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic mytest3

通过kafka服务端脚本创建topic:
./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic mytest3
--partitions 3，分区数为3数据只能存储在一个broker节点。

生产消息
./bin/kafka-console-producer.sh --broker-list 192.168.145.132:9092 --topic mytest3
消费消息
./bin/kafka-console-consumer.sh --bootstrap-server 192.168.145.132:9092 --topic mytest3 --from-beginning

