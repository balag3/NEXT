package com.next.model.internal;

import com.next.model.concrete.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("stops")
@Getter
@Setter
@Builder
public class Stop {

	private static final long EXPIRATION = 3L * 60L * 1000L;

	@Id
	private String id;

	private long lastFetched;

	private Schedule schedule; // TODO: should be a simplified model also from .internal

	public boolean isOutDated() {
		return lastFetched + EXPIRATION < System.currentTimeMillis();
	}

}
