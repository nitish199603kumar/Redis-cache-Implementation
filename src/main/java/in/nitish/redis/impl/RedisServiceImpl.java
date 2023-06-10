package in.nitish.redis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl {

	private static final String KEY="studentName";
	private static final long Expiration_Time=60;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	
	public void sendDataWithExpiration(Object data) {
		redisTemplate.opsForValue().set(KEY,data, Expiration_Time);
	}
	
	public Object getStoreData() {
		
		return redisTemplate.opsForValue().get(KEY);
	}
}
