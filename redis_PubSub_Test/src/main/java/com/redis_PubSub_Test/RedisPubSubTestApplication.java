package com.redis_PubSub_Test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisPubSubTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisPubSubTestApplication.class, args);
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
		solution333(name, yearning, photo);
	}

	public static int[] solution333(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        // name과 yearning map에 매핑
        for(int i = 0; i < name.length; i++) {
            String nameItem = name[i];
            int point = yearning[i];
            
            map.put(nameItem, point);
        }
        
        // photo에 있는 이름을 item에 담고 item의 값이 map key에 있을 경우 value 리턴하여 answer에 추가
        for(int i = 0; i < photo.length; i++) {
            for(String item : photo[i]) {
            	System.out.println("item =======> " + item);
                answer[i] += map.getOrDefault(item,0);    
            }
        }
        return answer;
    }
}
