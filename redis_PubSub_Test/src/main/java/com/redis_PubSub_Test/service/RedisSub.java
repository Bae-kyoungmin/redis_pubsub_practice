package com.redis_PubSub_Test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis_PubSub_Test.entity.Member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RedisSub implements MessageListener{

	@Autowired
	private ObjectMapper objectMapper;
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
	// ObjectMapper와 RedisTemplate 클래스는 Object라는 동일한 원시유형의 클래스를 갖으므로 동시 사용이 불가능함
	
	@Override
	public void onMessage(Message msg, byte[] pattern) {
		try {
            // simple message 테스트
//            String msg = (String) redisTemplate.getStringSerializer()
//                          .deserialize(message.getBody());
//            String data = objectMapper.readValue(msg, String.class);
//            System.out.println(data);


            // pojo 메시지 테스트
            Member member = objectMapper.readValue(msg.getBody(), Member.class);
            System.out.println(member.toString());
            System.out.println(member.getFirstName());
            System.out.println(member.getLastName());

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
