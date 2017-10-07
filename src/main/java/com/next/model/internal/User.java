package com.next.model.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("users")
public class User {

	@Id
	public String id;

}
