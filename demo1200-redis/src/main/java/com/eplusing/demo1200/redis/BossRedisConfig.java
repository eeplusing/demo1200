package com.eplusing.demo1200.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import java.util.Optional;
import java.util.Set;

/**
 * BossRedisConfig
 *
 * @author caopengpeng
 * @date 2021-10-19
 */
@Configuration
public class BossRedisConfig {

    @Value("${boss.redis.mode}")
    private String redisMode;

    @Value("${boss.redis.nodes}")
    private Set<String> redisHostAndPorts;

    @Value("${boss.redis.password:#{null}}")
    private String redisPwd;

    @Value("${boss.redis.master}")
    private String master;

    @Bean
    public RedisConnectionFactory connectionFactory() throws IllegalArgumentException {
        if ("Standalone".equalsIgnoreCase(redisMode)) {
            Optional<String> optional = redisHostAndPorts.stream().findFirst();
            if (optional.isPresent()) {
                String[] hostAndPort = optional.get().split(":");
                RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
                standaloneConfig.setPassword(redisPwd);
                return new LettuceConnectionFactory(standaloneConfig);
            } else {
                throw new IllegalArgumentException("redis.nodes 为空，请检查");
            }
        } else if ("Sentinel".equalsIgnoreCase(redisMode)) {
            RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration(master, redisHostAndPorts);
            sentinelConfig.setPassword(redisPwd);
            return new LettuceConnectionFactory(sentinelConfig);
        } else if ("Cluster".equalsIgnoreCase(redisMode)) {
            RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(redisHostAndPorts);
            clusterConfig.setMaxRedirects(3);
            clusterConfig.setPassword(redisPwd);
            return new LettuceConnectionFactory(clusterConfig);
        } else {
            throw new IllegalArgumentException("不支持的 Redis 启动模式" + redisMode + "，请设置 redis.mode=[ Standalone | Sentinel | Cluster ]");
        }
    }

    @Bean("bossRedisTemplate")
    public RedisTemplate<String, Object> bossRedisTemplate() {
        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    public ValueOperations<String, Object> valueOperations() {
        return bossRedisTemplate().opsForValue();
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations() {
        return bossRedisTemplate().opsForHash();
    }

    @Bean
    public ListOperations<String, Object> listOperations() {
        return bossRedisTemplate().opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations() {
        return bossRedisTemplate().opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations() {
        return bossRedisTemplate().opsForZSet();
    }

}