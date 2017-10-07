package com.next.model.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("stops")
public class Stop {

	private static final long EXPIRATION = 3L * 60L * 1000L;

	@Id
	public String id;
	public long lastFetched;
	// TODO: include other properties we need on our side, fix modifiers, add accessors

	public boolean isOutDated() {
		return lastFetched + EXPIRATION < System.currentTimeMillis();
	}

}
