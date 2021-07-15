1.主机清单：
~]# cat /etc/hosts
192.168.145.134 elk1.eplusing.com                #elk
192.168.145.135 elk2.eplusing.com                #elk
192.168.145.137 elk3.eplusing.com                #logstash+kafka
192.168.145.138 elk4.eplusing.com                #nginx + filebeat


2.
2.1 134,135配置jdk

/usr/local/java/jdk1.8.0_281

java]# vi /etc/profile.d/java.sh
export JAVA_HOME=/usr/local/java/jdk1.8.0_281
export PATH=$JAVA_HOME/bin:$PATH


java]# source /etc/profile.d/java.sh


2.2安装es
~]# cd /etc/elasticsearch
path.data: /var/lib/elasticsearch
path.logs: /var/log/elasticsearch

chown elasticsearch.elasticsearch /var/lib/elasticsearch/ -R
chown elasticsearch.elasticsearch /var/log/elasticsearch/ -R

 /usr/local/elasticsearch/logs/

cd /usr/local/elasticsearch/elasticsearch-7.7.0
./bin/elasticsearch -d

 curl http://192.168.145.134:9200

cd /usr/local/logstash/logstash-7.7.0
config/logstash.conf

nohup ./bin/logstash -f /usr/local/logstash/logstash-7.7.0/config/logstash.conf &


2.3安装kibana
cd /usr/local/kibana/kibana-7.7.0-linux-x86_64/bin

./kibana --allow-root &


2.4安装filebeat
cd /usr/local/filebeat/filebeat-7.7.0-linux-x86_64
nohup ./filebeat -e -c filebeat.yml &

