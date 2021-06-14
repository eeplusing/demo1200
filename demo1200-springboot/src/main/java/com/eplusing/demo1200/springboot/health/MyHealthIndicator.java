package com.eplusing.demo1200.springboot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		return Health.up().withDetail("error", "spring boot error").build();
		//return Health.down().withDetail("error", "spring boot error").build();
	}

}
