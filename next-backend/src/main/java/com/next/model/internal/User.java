package com.next.model.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("users")
public class User {

	@Id
	public String id;
	// TODO: include other properties we need on our side, fix modifiers, add accessors
	// e.g. List<String> stopIds; storing the saved stops of the user
}
