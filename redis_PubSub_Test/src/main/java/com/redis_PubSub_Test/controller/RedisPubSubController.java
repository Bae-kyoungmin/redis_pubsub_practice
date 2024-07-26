package com.redis_PubSub_Test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis_PubSub_Test.entity.Address;
import com.redis_PubSub_Test.entity.Member;
import com.redis_PubSub_Test.service.RedisPub;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("pubsub")
public class RedisPubSubController {

	@Autowired
	private ChannelTopic topic;
	@Autowired
	private RedisPub redisPub;

	//postman -> http://localhost:8019/pubsub/topics/myTopic
	@PostMapping("/topics/myTopic")
	public String pushMessage() {
		Address address = new Address("Korea Seoul", "gangnam");
		Member member = new Member(null, "tester", "bae", address);
		redisPub.publishPojo(topic, member);
		return "완료";
	}
}
