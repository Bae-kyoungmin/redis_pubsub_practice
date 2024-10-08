package com.redis_PubSub_Test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.redis_PubSub_Test.service.RedisSub;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private int port;
    
    @Autowired
    private RedisSub redisSub;
    
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
    	return new LettuceConnectionFactory(host, port);
    }
    
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
    	RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
    	redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
    	redisMessageListenerContainer.addMessageListener(redisSub, myTopic());
    	return redisMessageListenerContainer;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    	RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    	redisTemplate.setConnectionFactory(redisConnectionFactory);
    	redisTemplate.setKeySerializer(new StringRedisSerializer());
    	redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
    	return redisTemplate;
    }
    
    @Bean
    public ChannelTopic myTopic() {
    	return new ChannelTopic("myTopic");
    }
    
}
