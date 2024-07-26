package com.redis_PubSub_Test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import com.redis_PubSub_Test.entity.Member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RedisPub {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public void publish(ChannelTopic topic, String msg) {
		redisTemplate.convertAndSend(topic.getTopic(), msg);
	}
	
	public void publishPojo(ChannelTopic topic, Member member) {
		redisTemplate.convertAndSend(topic.getTopic(), member);
	}
	
}
